package net.kav.soul.event;

import net.bettercombat.client.animation.IExtendedAnimation;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.kav.soul.data.ItemPointremove;
import net.kav.soul.networking.ModMessages;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.windows.POINT;

public class animationevents {

private static boolean con;
    //@Override
   // public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
    //       float xs= SoulData.removeFloatpoint(((IEntityDataSaver) player), ItemPointremove.getPoint(),"Stamina");
    //        PacketByteBuf buf= PacketByteBufs.create();
    //
    //        buf.writeFloat(ItemPointremove.getPoint());
    //        ClientPlayNetworking.send(ModMessages.POINT,buf);
    //      setcon(true);
    //        return ActionResult.PASS;
    //    }
    public static boolean getcon()
    {
        return con;
    }

    public static void setcon(boolean condi)
    {
       con= condi;
    }


}
