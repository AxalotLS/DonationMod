package com.axalotl.donationmod.mixins;

import com.axalotl.donationmod.events.Values;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class EntityRendererMixin <E extends Entity>{
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void on(E entity, double x, double y, double z, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        if(Values.noMob && !(entity instanceof PlayerEntity) && entity instanceof LivingEntity){
            ci.cancel();
        }
    }
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void onCasinoEvent(E entity, double x, double y, double z, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        if(Values.noFriends && entity instanceof PlayerEntity && MinecraftClient.getInstance().player != entity){
            ci.cancel();
        }
    }
}
