package com.axalotl.donationmod.donationalerts;

public enum  AlertType {
    Undefined(-1),
    Donate(1),
    TwitchSubscription(4),
    TwitchFreeFollow(6),
    YouTubeSubscription(7);
    public final int Value;
    AlertType(int value) {
        Value = value;
    }
    public static AlertType valueOf(int value) {
        return switch (value) {
            case 1 -> AlertType.Donate;
            case 4 -> AlertType.TwitchSubscription;
            case 6 -> AlertType.TwitchFreeFollow;
            case 7 -> AlertType.YouTubeSubscription;
            default -> AlertType.Undefined;
        };
    }
}
