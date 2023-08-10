package com.axalotl.donationmod.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EventEffects {
    public static StatusEffect STOP_MOVE;
    public static StatusEffect CANCEL_DAMAGE;
    public static StatusEffect NO_BOW;
    public static StatusEffect NO_JUMP;
    public static StatusEffect NO_MOB;
    public static StatusEffect ROTATE_SCREEN;
    public static StatusEffect INVERTED_CONTROL;
    public static StatusEffect KICK;
    public static StatusEffect DISABLE_ELYTRA;
    public static StatusEffect SLOWDOWN;
    public static StatusEffect THIRD_PERSON;
    public static StatusEffect CINEMATIC_CAMERA;
    public static StatusEffect NO_FRIENDS;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier("donation_mod", name),
                new DonationEffect(StatusEffectCategory.BENEFICIAL, 31246867));
    }
    public static void registerEffects(){
        STOP_MOVE = registerStatusEffect("stop_move");
        CANCEL_DAMAGE = registerStatusEffect("cancel_damage");
        NO_BOW = registerStatusEffect("no_bow");
        NO_JUMP = registerStatusEffect("no_jump");
        NO_MOB = registerStatusEffect("no_mob");
        ROTATE_SCREEN = registerStatusEffect("rotate_screen");
        INVERTED_CONTROL = registerStatusEffect("inverted_control");
        KICK = registerStatusEffect("kick");
        DISABLE_ELYTRA = registerStatusEffect("disable_elytra");
        SLOWDOWN = registerStatusEffect("slowdown");
        THIRD_PERSON = registerStatusEffect("third_person");
        CINEMATIC_CAMERA = registerStatusEffect("cinematic_camera");
        NO_FRIENDS = registerStatusEffect("no_friends");
    }
}
