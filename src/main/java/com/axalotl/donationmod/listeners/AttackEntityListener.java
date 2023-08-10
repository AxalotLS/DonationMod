package com.axalotl.donationmod.listeners;

import com.axalotl.donationmod.events.Values;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityListener implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (player != null && entity.isAttackable() && Values.cancelDamage) {
            return ActionResult.FAIL;
        }
        if (Values.casinoActive) {
            return ActionResult.FAIL;
        }
        return ActionResult.PASS;
    }
}
