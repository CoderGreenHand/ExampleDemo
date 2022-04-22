package com.example.service;

import com.google.common.collect.Maps;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HqHeader {

    public static String hmacHash(String key, String data)
            throws Exception {
        String algorithm = "HmacSHA256";
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), algorithm);
        Mac mac = Mac.getInstance(algorithm);
        mac.init(signingKey);
        return Base64.getEncoder().encodeToString(mac.doFinal(data.getBytes()));
    }

    public static Map<String, String> headers(String username, String password) throws Exception {
        Map<String, String> headers = Maps.newLinkedHashMap();
        DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = df.format(new Date());
        headers.put("date", date);
        String rawSign = "date: " + date;

        String authHeader = String.format(
                "hmac username=\"%s\", algorithm=\"hmac-sha256\", headers=\"date\", signature=\"%s\"",
                username, hmacHash(password, rawSign));

        headers.put("Authorization", authHeader);

        return headers;
    }

    public static void main(String[] args) throws Exception {
        Map<String,String> header = headers("3f77f9d822ac429c9bca60afd09a43aa","KACDMFJPkzQVXJj3lj855t2Zk2MuA2sL");
        for(Map.Entry entry:header.entrySet()){
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

    }
}
