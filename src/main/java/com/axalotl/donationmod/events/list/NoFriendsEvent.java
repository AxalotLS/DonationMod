package com.axalotl.donationmod.events.list;

import com.axalotl.donationmod.DonationMod;
import com.axalotl.donationmod.donationalerts.DonationAlertsEvent;
import com.axalotl.donationmod.effects.EventEffects;
import com.axalotl.donationmod.events.DonationEvent;
import com.axalotl.donationmod.events.Event;
import com.axalotl.donationmod.events.Values;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.effect.StatusEffect;

import java.util.Timer;
import java.util.TimerTask;

public class NoFriendsEvent extends Event {
    public NoFriendsEvent(String name, int duration) {
        super(name, duration);
    }

    @Override
    public void execute(DonationAlertsEvent donationAlertsEvent) {
        if(MinecraftClient.getInstance().player == null) {
            DonationEvent.activeEvents.removeIf(event -> event instanceof NoFriendsEvent);
            return;
        }
        Values.noFriends = true;
        DonationEvent.addDonationText(null, I18n.translate("effect.donation_mod.no_friends"));
        StatusEffect effect = EventEffects.NO_FRIENDS;
        DonationEvent.addEventEffect(effect,getDuration(), 0);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Values.noFriends = false;
                DonationEvent.activeEvents.removeIf(event -> event instanceof NoFriendsEvent);
            }
        }, getDuration() * 1000L);
    }
}
