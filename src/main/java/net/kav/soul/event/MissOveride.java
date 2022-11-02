package net.kav.soul.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.kav.soul.data.ItemPointremove;
import net.kav.soul.data.ItemType;
import net.kav.soul.networking.ModMessages;
import net.kav.soul.util.GlobalSoul;
import net.kav.soul.util.IEntityDataSaver;
import net.kav.soul.util.SoulData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import java.util.List;

public class MissOveride {
    private static boolean con;

    public static void print()
    {
        System.out.println("s");
        if(!MinecraftClient.getInstance().player.isCreative())
        {
            con=true;
        ClientPlayNetworking.send(ModMessages.HANDSWING, PacketByteBufs.empty());
    }

    }

    public static void setCon(boolean cons)
    {
        con=cons;
    }

    public static boolean getCon()
    {
       return con;
    }








}
