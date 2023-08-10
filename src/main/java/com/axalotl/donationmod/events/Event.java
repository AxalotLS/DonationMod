package com.axalotl.donationmod.events;

import com.axalotl.donationmod.donationalerts.DonationAlertsEvent;

public abstract class Event {
    private final String name;
    private int duration;

    public Event(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public abstract void execute(DonationAlertsEvent donationAlertsEvent);
}
