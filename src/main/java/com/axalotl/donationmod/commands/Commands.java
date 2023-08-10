package com.axalotl.donationmod.commands;

import com.axalotl.donationmod.DonationMod;
import com.axalotl.donationmod.donationalerts.DonationAlertsEvent;
import com.axalotl.donationmod.events.DonationEvent;
import com.axalotl.donationmod.events.Event;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.language.I18n;

import java.util.stream.Stream;

import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class Commands {
    private Commands() {
    }

    public static void registerCommands() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) ->
                dispatcher.register(literal("donations")
                        .then(literal("token")
                                .then(argument("token", string())
                                        .executes(ctx -> {
                                            DonationMod.getConfig().setToken(getString(ctx, "token"));
                                            DonationMod.save();
                                            DonationMod.DonationAlertsInformation(I18n.translate("text.donation_mod.message.token_set"));
                                            return 1;
                                        })))
                        .then(literal("run_event")
                                .then(argument("name", string())
                                        .executes(ctx -> {
                                            Event[] allEvents = Stream.of(DonationEvent.veryBigDonationEvents, DonationEvent.bigDonations, DonationEvent.smallDonationEvents, DonationEvent.testEvents)
                                                    .flatMap(Stream::of)
                                                    .toArray(Event[]::new);

                                            Event event = DonationEvent.getEventByName(allEvents, getString(ctx, "name"));
                                            if (event != null) {
                                                DonationAlertsEvent event1 = new DonationAlertsEvent();
                                                event1.Amount = 9999999;
                                                if(MinecraftClient.getInstance().player != null){
                                                    event1.UserName = MinecraftClient.getInstance().player.getName().getString();
                                                }
                                                event.execute(event1);
                                            }
                                            return 1;
                                        })))));
    }
}
