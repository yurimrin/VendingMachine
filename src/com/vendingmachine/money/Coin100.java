package com.vendingmachine.money;

public class Coin100 {
    public static boolean isCorrect(String value) {
        if (value.equals("100")) {
            return true;
        }
        return false;
    }
}
