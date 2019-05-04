package com.vendingmachine;

import com.vendingmachine.drink.Drink;
import com.vendingmachine.money.Coin100;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VendingMachine v = new VendingMachine();

        Scanner scanner = new Scanner(System.in);

        String input = "";
        // 買うまでループ
        while(true) {

            boolean selectDrink = false;

            // 金額を満たすまでループ
            while(true) {
                // メニュー表示
                System.out.println(v.menu());

                input = scanner.nextLine();

                if (isSelectDrink(input) && v.isCorrectMenu(input)) {
                    // 飲み物選択
                    selectDrink = true;

                    break;
                }

                // お金投入
                if (Coin100.isCorrect(input)) {
                    // コインを入れる
                    v.receive(new Coin100());
                } else {
                    System.out.println("正しく入力してね！");
                }

            }
            if (selectDrink) {
                Drink drink = v.offer(input);
                if (drink == null) {
                    System.out.println("正しく入力してね！");
                } else {
                    System.out.println(drink);
                    break;
                }

            }
        }

        scanner.close();
    }

    private static boolean isSelectDrink(String input) {
        try {
            // お金投入 or 飲み物選択かどうか
            Integer.parseInt(input);
            return false;

        } catch (NumberFormatException e) {
            return true;
        }
    }
}
