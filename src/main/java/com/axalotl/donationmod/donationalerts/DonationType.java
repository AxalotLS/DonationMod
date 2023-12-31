package com.axalotl.donationmod.donationalerts;

import com.google.common.collect.Lists;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DonationType {
    public boolean Active;

    private List<String> Messages;
    private List<String> Commands;

    public String Name = "";
    public float CurrencyBRL;
    public float CurrencyBYN;
    public float CurrencyEUR;
    public float CurrencyKZT;
    public float CurrencyRUB;
    public float CurrencyUAH;
    public float CurrencyUSD;

    public float getAmountByCurrency(String currency) {
        return switch (currency) {
            case "BRL" -> CurrencyBRL;
            case "BYN" -> CurrencyBYN;
            case "EUR" -> CurrencyEUR;
            case "KZT" -> CurrencyKZT;
            case "RUB" -> CurrencyRUB;
            case "UAH" -> CurrencyUAH;
            case "USD" -> CurrencyUSD;
            default -> 10000000f;
        };
    }

    public static DonationType getDonationType(String data) throws JSONException
    {
        JSONObject json = new JSONObject(data);
        DonationType obj = new DonationType();
        if (json.has("active"))
            obj.Active = json.getBoolean("active");
        if (json.has("m"))
        {
            JSONArray jarr = json.getJSONArray("m");
            if (jarr != null)
            {
                obj.Messages = new ArrayList<>();
                for (int i = 0; i < jarr.length(); i++)
                    obj.Messages.add(jarr.getString(i));
            }
        }
        if (json.has("c"))
        {
            JSONArray jarr = json.getJSONArray("c");
            if (jarr != null)
            {
                obj.Commands = new ArrayList<>();
                for (int i = 0; i < jarr.length(); i++)
                    obj.Commands.add(jarr.getString(i));
            }
        }
        if (json.has("BRL"))
            obj.CurrencyBRL = (float) json.getDouble("BRL");
        if (json.has("BYN"))
            obj.CurrencyBYN = (float) json.getDouble("BYN");
        if (json.has("EUR"))
            obj.CurrencyEUR = (float) json.getDouble("EUR");
        if (json.has("KZT"))
            obj.CurrencyKZT = (float) json.getDouble("KZT");
        if (json.has("RUB"))
            obj.CurrencyRUB = (float) json.getDouble("RUB");
        if (json.has("UAH"))
            obj.CurrencyUAH = (float) json.getDouble("UAH");
        if (json.has("USD"))
            obj.CurrencyUSD = (float) json.getDouble("USD");
        if (json.has("name"))
            obj.Name = json.getString("name");
        return obj;
    }

    public String toString()
    {
        JSONObject json = new JSONObject();
        try {
            json.put("active", Active);
            json.put("m", Messages);
            json.put("c", Commands);
            json.put("BRL", CurrencyBRL);
            json.put("BYN", CurrencyBYN);
            json.put("EUR", CurrencyEUR);
            json.put("KZT", CurrencyKZT);
            json.put("RUB", CurrencyRUB);
            json.put("UAH", CurrencyUAH);
            json.put("USD", CurrencyUSD);
            json.put("name", Name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public List<String> getMessages() {
        return Messages;
    }
    public List<String> getCommands() {
        return Commands;
    }
    public void AddMessage(String value) {
        if (Messages == null)
            Messages = Lists.newArrayList();
        Messages.add(value);
    }
    public void AddCommand(String value) {
        if (Commands == null)
            Commands = Lists.newArrayList();
        Commands.add(value);
    }
    public void setMessages(List<String> value) {
        Messages = value;
    }
    public void setCommands(List<String> value) {
        Commands = value;
    }
}
