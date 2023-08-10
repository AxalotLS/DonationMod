package com.axalotl.donationmod.listeners;

import com.axalotl.donationmod.events.Values;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class AttackBlockListener implements AttackBlockCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
        if (world != null && world.getBlockState(pos).getBlock() != null && (Values.disableBlockBreak || Values.casinoActive)) {
            return ActionResult.FAIL;
        }
        return ActionResult.PASS;
    }
}
