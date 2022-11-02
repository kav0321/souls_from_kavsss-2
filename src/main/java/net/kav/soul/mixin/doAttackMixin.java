package net.kav.soul.mixin;


import net.kav.soul.event.Miss;
import net.kav.soul.event.MissOveride;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class doAttackMixin {



    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;doAttack()Z"), method = "handleInputEvents()V", cancellable = true)
    public void doAttack(CallbackInfo info)
    {
        MissOveride.print();

    }
}
