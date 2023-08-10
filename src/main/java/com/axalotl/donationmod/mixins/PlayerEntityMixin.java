package com.axalotl.donationmod.mixins;

import com.axalotl.donationmod.events.Values;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void onJump(CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.getWorld().isClient && Values.enableNoJump) {
            ci.cancel();
        }
    }
    @Inject(method = "travel", at = @At("HEAD"), cancellable = true)
    private void onMove(CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && player.getWorld().isClient && player.isOnGround() && Values.disablePlayerMovements || Values.casinoActive) {
            player.setVelocity(0, 0, 0);
            player.setMovementSpeed(0);
            ci.cancel();
        }
    }
}
