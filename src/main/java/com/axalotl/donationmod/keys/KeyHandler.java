package com.axalotl.donationmod.keys;

import com.axalotl.donationmod.DonationMod;
import com.axalotl.donationmod.config.ModConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyHandler {
    private static final String CATEGORY = "key.categories.donation_mod";

    private KeyHandler() {
    }

    public static void registerBindings() {
        registerConnectToggleKey();
        registerDisconnectToggleKey();
    }

    private static void registerConnectToggleKey() {
        KeyBinding connect = new KeyBinding("key.donation_mod.connect_toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, CATEGORY);
        KeyBindingHelper.registerKeyBinding(connect);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (connect.wasPressed()) {
                ModConfig config = DonationMod.getConfig();
                if (!config.getToken().isEmpty() && !config.getToken().equals("TOKEN")) {
                    if (DonationMod.da.getConnected())
                        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of(I18n.translate("text.donation_mod.message.prefix") + " " + I18n.translate("text.donation_mod.message.already_connected")));
                    else DonationMod.da.Connect(DonationMod.getConfig().getToken());
                } else
                    MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of(I18n.translate("text.donation_mod.message.prefix") + " " + I18n.translate("text.donation_mod.message.token_error")));
            }
        });
    }

    private static void registerDisconnectToggleKey() {
        KeyBinding disconnect = new KeyBinding("key.donation_mod.disconnect_toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, CATEGORY);
        KeyBindingHelper.registerKeyBinding(disconnect);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (disconnect.wasPressed()) {
                if (DonationMod.da.getConnected()) DonationMod.da.Disconnect();
                else
                    MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of(I18n.translate("text.donation_mod.message.prefix") + " " + I18n.translate("text.donation_mod.message.not_connected")));
            }
        });
    }
}
