package com.axalotl.donationmod.donationalerts;

import com.axalotl.donationmod.DonationMod;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;
import net.minecraft.client.resource.language.I18n;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

public class DonationAlerts {
    private Socket sock;
    private URI _url;
    private String _token;

    private Listener connectListener;
    private Listener disconectListener;
    private Listener donationListener;
    private Listener errorListener;

    public DonationAlerts(String server) throws URISyntaxException {
        _url = new URI(server);
        sock = IO.socket(_url);

        connectListener = new Listener() {
            @Override
            public void call(Object... arg0) {
                DonationMod.DonationAlertsInformation(I18n.translate("text.donation_mod.message.connect"));
            }
        };

        disconectListener = new Listener() {
            @Override
            public void call(Object... arg0) {
                DonationMod.DonationAlertsInformation(I18n.translate("text.donation_mod.message.disconnect"));
            }
        };

        donationListener = new Listener() {
            @Override
            public void call(Object... arg0) {
                DonationMod.AddDonation(DonationAlertsEvent.getDonationAlertsEvent((String) arg0[0]));
            }
        };

        errorListener = new Listener() {
            @Override
            public void call(Object... arg0) {
                DonationMod.DonationAlertsInformation(I18n.translate("text.donation_mod.message.error"));
            }
        };

        sock.on(Socket.EVENT_CONNECT, connectListener)
                .on(Socket.EVENT_DISCONNECT, disconectListener)
                .on(Socket.EVENT_ERROR, errorListener)
                .on("donation", donationListener);
    }

    public void Connect(String token) throws JSONException {
        _token = token;
        sock.connect();
        sock.emit("add-user", new JSONObject()
                .put("token", _token)
                .put("type", "minor"));
    }

    public void Disconnect() {
        sock.disconnect();
    }

    public boolean getConnected() {
        return sock.connected();
    }
}
