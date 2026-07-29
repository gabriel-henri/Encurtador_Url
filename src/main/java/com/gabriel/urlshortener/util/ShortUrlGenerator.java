package com.gabriel.urlshortener.util;

import java.security.SecureRandom;

public class ShortUrlGenerator {
    private static final String possibilits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final SecureRandom rand = new SecureRandom();

    public String gererate(int len){
        StringBuilder build = new StringBuilder();

        for(int i = 0; i < len; i++){
            int index = rand.nextInt(possibilits.length());
            build.append(possibilits.charAt(index));
        }
        return build.toString();
    }
}
