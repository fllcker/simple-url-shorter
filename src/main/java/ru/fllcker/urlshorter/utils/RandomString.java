package ru.fllcker.urlshorter.utils;

import java.util.Random;

/**
 * @author github.com/fllcker
 */
public class RandomString {
    public static String generateString(int length)
    {
        Random rng = new Random();
        String characters = "QWERTYUIOPASDFGHJKLZXCVBNM";

        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
