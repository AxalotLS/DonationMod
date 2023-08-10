package com.axalotl.donationmod.mixins;

import net.minecraft.client.render.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Camera.class)
public interface CameraAccessor {
    @Accessor("pitch")
    void setPitch(float pitch);

    @Accessor("yaw")
    void setYaw(float yaw);
}
