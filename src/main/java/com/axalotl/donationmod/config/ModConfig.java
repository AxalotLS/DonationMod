package com.axalotl.donationmod.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@SuppressWarnings("FieldMayBeFinal")
@Config(name = "donation_mod")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    private String Token = "TOKEN";
    static class EffectEventSettings {
        @ConfigEntry.Gui.Tooltip
        private int firstEffectDonationAmount = 10;
        @ConfigEntry.Gui.Tooltip
        private int firstEffectDuration = 15;
        @ConfigEntry.Gui.Tooltip
        private int secondEffectDonationAmount = 20;
        @ConfigEntry.Gui.Tooltip
        private int secondEffectDuration = 20;
        @ConfigEntry.Gui.Tooltip
        private int thirdEffectDonationAmount = 30;
        @ConfigEntry.Gui.Tooltip
        private int thirdEffectDuration = 30;
    }
    static class EventsSettings {
        @ConfigEntry.Gui.Tooltip
        private int bigDonationsAmount = 50;
        @ConfigEntry.Gui.Tooltip
        private int VeryBigDonationsAmount = 500;
        @ConfigEntry.Gui.Tooltip
        private int stopMoveDuration = 30;
        @ConfigEntry.Gui.Tooltip
        private int noJumpDuration = 60;
        @ConfigEntry.Gui.Tooltip
        private int noMobDuration = 120;
        @ConfigEntry.Gui.Tooltip
        private int rotateScreenDuration = 120;
        @ConfigEntry.Gui.Tooltip
        private int invertedControlDuration = 300;
        @ConfigEntry.Gui.Tooltip
        private int cinematicCameraDuration = 120;
        @ConfigEntry.Gui.Tooltip
        private int cancelDamageDuration = 300;
        @ConfigEntry.Gui.Tooltip
        private int noBowDuration = 300;
        @ConfigEntry.Gui.Tooltip
        private int disableElytraDuration = 600;
        @ConfigEntry.Gui.Tooltip
        private int noFriendsDuration = 900;
        @ConfigEntry.Gui.Tooltip
        private int slowdownDuration = 180;
        @ConfigEntry.Gui.Tooltip
        private int thirdPersonDuration = 300;
        @ConfigEntry.Gui.Tooltip
        private boolean enableCasino = false;
    }

    @ConfigEntry.Gui.CollapsibleObject
    private EffectEventSettings effectEventSettings = new EffectEventSettings();
    @ConfigEntry.Gui.CollapsibleObject
    private EventsSettings eventsSettings = new EventsSettings();
    public String getToken() {
        return Token;
    }
    public boolean isEnabledCasino(){
        return eventsSettings.enableCasino;
    }
    public int getVeryBigDonationAmount(){
        return eventsSettings.VeryBigDonationsAmount;
    }
    public void setToken(String token) {
        this.Token = token;
    }
    public int getNoBowDuration(){
        return eventsSettings.noBowDuration;
    }
    public int getCinematicCameraDuration(){
        return eventsSettings.cinematicCameraDuration;
    }
    public int getNoFriendsDuration(){
        return eventsSettings.noFriendsDuration;
    }
    public int getThirdPersonDuration(){
        return eventsSettings.thirdPersonDuration;
    }
    public int getSlowdownDuration(){
        return eventsSettings.slowdownDuration;
    }
    public int getDisableElytraDuration(){
        return eventsSettings.disableElytraDuration;
    }
    public int getBigDonationAmount(){
        return eventsSettings.bigDonationsAmount;
    }
    public int getCancelDamageDuration(){
        return eventsSettings.cancelDamageDuration;
    }
    public int getInvertedControlDuration(){
        return eventsSettings.invertedControlDuration;
    }
    public int getStopMoveDuration() {
        return eventsSettings.stopMoveDuration;
    }
    public int getNoMobDuration() {
        return eventsSettings.noMobDuration;
    }
    public int getRotateScreenDuration() {
        return eventsSettings.rotateScreenDuration;
    }
    public int getNoJumpDuration() {
        return eventsSettings.noJumpDuration;
    }
    public int getFirstEffectDonationAmount() {
        return effectEventSettings.firstEffectDonationAmount;
    }
    public int getFirstEffectDuration() {
        return effectEventSettings.firstEffectDuration;
    }
    public int getSecondEffectDonationAmount() {
        return effectEventSettings.secondEffectDonationAmount;
    }
    public int getSecondEffectDuration() {
        return effectEventSettings.secondEffectDuration;
    }
    public int getThirdEffectDonationAmount() {
        return effectEventSettings.thirdEffectDonationAmount;
    }
    public int getThirdEffectDuration() {
        return effectEventSettings.thirdEffectDuration;
    }
}