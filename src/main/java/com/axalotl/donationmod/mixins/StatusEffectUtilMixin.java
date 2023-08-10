package com.axalotl.donationmod.mixins;

import com.axalotl.donationmod.effects.EventEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StatusEffectUtil.class)

public class StatusEffectUtilMixin {
    @Inject(method = "getDurationText", at = @At("HEAD"), cancellable = true)
    private static void setText(StatusEffectInstance effect, float multiplier, CallbackInfoReturnable<Text> info) {
        if (effect.getEffectType().equals(EventEffects.KICK)) {
            info.setReturnValue(Text.literal("∞"));
        }
    }
}
