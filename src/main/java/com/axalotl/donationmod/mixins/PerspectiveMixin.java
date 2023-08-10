package com.axalotl.donationmod.mixins;

import com.axalotl.donationmod.events.Values;
import net.minecraft.client.option.Perspective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Perspective.class)
public class PerspectiveMixin {
    @Inject(method = "isFirstPerson",at=@At("RETURN"), cancellable = true)
    private void isFirstPerson(CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(cir.getReturnValue()&& !Values.thirdPersonView);
    }
    @Inject(method = "isFirstPerson",at=@At("RETURN"), cancellable = true)
    private void isFirstPersonCasino(CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(Values.casinoActive);
    }
    @Inject(method = "isFrontView",at=@At("RETURN"), cancellable = true)
    private void isFrontView(CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(cir.getReturnValue()&& !Values.thirdPersonView);
    }
}
