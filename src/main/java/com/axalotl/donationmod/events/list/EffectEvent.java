package com.axalotl.donationmod.events.list;

import com.axalotl.donationmod.DonationMod;
import com.axalotl.donationmod.config.ModConfig;
import com.axalotl.donationmod.donationalerts.DonationAlertsEvent;
import com.axalotl.donationmod.events.DonationEvent;
import com.axalotl.donationmod.events.Event;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EffectEvent extends Event {
    private final Random random = new Random();
    private static final StatusEffect[] EFFECTS = {
            StatusEffects.NAUSEA,
            StatusEffects.BLINDNESS,
            StatusEffects.DARKNESS,
            StatusEffects.MINING_FATIGUE
    };
    public EffectEvent(String name, int duration) {
        super(name, duration);
    }
    @Override
    public void execute(DonationAlertsEvent donationAlertsEvent) {
        ModConfig config = DonationMod.getConfig();
        StatusEffect effect = getRandomEffect();
        int amount = (int) donationAlertsEvent.Amount;
        if (MinecraftClient.getInstance().player == null) {
            DonationEvent.activeEvents.removeIf(event -> event instanceof EffectEvent);
            return;
        }
        if (amount >= config.getThirdEffectDonationAmount()) {
            setDuration(config.getThirdEffectDuration());
        } else if (amount >= config.getSecondEffectDonationAmount()) {
            setDuration(config.getSecondEffectDuration());
        } else if (amount >= config.getFirstEffectDonationAmount()) {
            setDuration(config.getFirstEffectDuration());
        }
        if(effect.equals(StatusEffects.MINING_FATIGUE)){
            DonationEvent.addEventEffect(effect, getDuration(), 3);
        } else {
            DonationEvent.addEventEffect(effect, getDuration(), 0);
        }
        Timer timer = new Timer();
        DonationEvent.addDonationText(I18n.translate(effect.getTranslationKey()), null);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                DonationEvent.activeEvents.removeIf(event -> event instanceof EffectEvent);
                timer.cancel();
            }
        }, getDuration() * 1000L);
    }
    private StatusEffect getRandomEffect(){
        return EFFECTS[random.nextInt(EFFECTS.length)];
    }
}
