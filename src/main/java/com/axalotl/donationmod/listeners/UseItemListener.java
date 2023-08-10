package com.axalotl.donationmod.listeners;

import com.axalotl.donationmod.events.Values;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class UseItemListener implements UseItemCallback {
    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        if((player.getMainHandStack().getItem().equals(Items.ENDER_PEARL)
                || player.getMainHandStack().getItem().equals(Items.WATER_BUCKET)
                || player.getMainHandStack().getItem().equals(Items.LAVA_BUCKET))
                && Values.disableEnderPearls){
            return TypedActionResult.fail(player.getMainHandStack());
        }
        if(Values.noBow && (player.getMainHandStack().getItem().equals(Items.BOW)
                || player.getMainHandStack().getItem().equals(Items.CROSSBOW)
                || player.getMainHandStack().getItem().equals(Items.TRIDENT))){
            return TypedActionResult.fail(player.getMainHandStack());
        }
        if(Values.casinoActive){
            return TypedActionResult.fail(player.getMainHandStack());
        }
        return TypedActionResult.pass(player.getMainHandStack());
    }
}
