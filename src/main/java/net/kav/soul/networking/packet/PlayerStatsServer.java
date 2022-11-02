package net.kav.soul.networking.packet;

import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.data.ItemType;
import net.kav.soul.networking.ModMessages;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import static java.lang.Math.abs;
import static net.kav.soul.util.SoulData.addFloatpoint;

public class PlayerStatsServer {







    public static void sendstats(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {
        float x12;
        double d = 0;
        ItemStack itemss = player.getMainHandStack();
        Item item = itemss.getItem();
        Multimap<EntityAttribute, EntityAttributeModifier> multimap = itemss.getAttributeModifiers(EquipmentSlot.MAINHAND);
        if (!multimap.isEmpty()) {
            Iterator var11 = multimap.entries().iterator();
            while(var11.hasNext()) {
                Map.Entry<EntityAttribute, EntityAttributeModifier> entry = (Map.Entry)var11.next();
                EntityAttributeModifier entityAttributeModifier = (EntityAttributeModifier)entry.getValue();
                d = entityAttributeModifier.getValue();

            }
            //EntityAttributeModifier entityAttributeModifier = (EntityAttributeModifier) item.getAttributeModifiers(EquipmentSlot.MAINHAND).get(EntityAttributes.GENERIC_ATTACK_SPEED);
            d=abs(d);
            player.sendMessage(Text.of(Double.toString(d)),true);
        }

        ItemType types= new ItemType();


        //////player.sendMessage(Text.of(Float.toString(SoulData.addFloatpoint(((IEntityDataSaver) player), 0f, "Stamina"))),true);


        if(player.isCreative())
        {
            x12=0;
        }
        else
            x12= (float) (d)+3;


        float xz =SoulData.removeFloatpoint(((IEntityDataSaver) player),x12,"Stamina");
        PacketByteBuf bufs = PacketByteBufs.create();
        bufs.writeFloat(xz);
        ServerPlayNetworking.send(player,ModMessages.STAMINA2,bufs);
    }




    public static void getsta(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender)
    {

        float x=buf.readFloat();
       // player.sendMessage(Text.of(Float.toString(x)),true);

        float f=addFloatpoint(((IEntityDataSaver) player),x,"Stamina");
        //server.sendSystemMessage(Text.of(Float.toString(f)), UUID.randomUUID());

    }




    public static void getstas(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf buf, PacketSender packetSender) {
        float x=buf.readFloat();
        // player.sendMessage(Text.of(Float.toString(x)),true);

        (((IEntityDataSaver) client.player)).getPersistentData().putFloat("Stamina",x);
    }
}
