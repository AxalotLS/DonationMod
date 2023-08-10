package com.axalotl.donationmod.events;

import java.util.Random;

public class EventRandomizer {
    private final Event[] events;
    private int currentIndex;
    private final Random random;

    public EventRandomizer(Event[] events) {
        this.events = events;
        this.currentIndex = 0;
        this.random = new Random();
    }

    public Event getRandomEvent() {
        if (currentIndex == events.length) {
            currentIndex = 0;
        }
        int randomIndex = random.nextInt(events.length - currentIndex) + currentIndex;

        Event selectedEvent = events[randomIndex];
        events[randomIndex] = events[currentIndex];
        events[currentIndex] = selectedEvent;

        currentIndex++;
        return selectedEvent;
    }
}
