package com.vendingmachine;

import com.vendingmachine.drink.Cola;
import com.vendingmachine.drink.Drink;
import com.vendingmachine.drink.GreenTea;
import com.vendingmachine.money.Coin100;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Drink> colaList = new ArrayList<Drink>();
    private List<Drink> greenTeaList = new ArrayList<Drink>();
    private List<Coin100> coins = new ArrayList<Coin100>();

    public VendingMachine() {
        refill();
    }

    private void refill() {
        colaList.add(new Cola());

        greenTeaList.add(new GreenTea());
    }

    public String menu(){
        String colaMenu = "a. cola " + (colaList.size() > 0 ? "ある" : "ない") + " price: " + Cola.price;
        String greenTeaMenu = "b. green tea " + (greenTeaList.size() > 0 ? "ある" : "ない") + " price: " + GreenTea.price;

        if (deposit() == 0) {
            // 全メニュー
            return colaMenu + "\n" +
                    greenTeaMenu;
        } else {
            // 買えるメニュー
            StringBuffer sb = new StringBuffer();
            sb.append("買える飲み物！\n");
            if (deposit() >= Cola.price && colaList.size() > 0) {
                sb.append(colaMenu + "\n");
            }
            if (deposit() >= GreenTea.price && greenTeaList.size() > 0) {
                sb.append(greenTeaMenu + "\n");
            }
            return sb.toString();
        }
    }

    public Drink offer(String menu) {
        Drink d = null;
        if (menu.equals("a")) {
            if (deposit() >= Cola.price) {
                d = colaList.get(0);
                colaList.remove(d);
            }
        } else if (menu.equals("b")) {
            if (deposit() >= GreenTea.price) {
                d = greenTeaList.get(0);
                greenTeaList.remove(d);
            }
        }
        return d;
    }

    // コイン投入
    public void receive(Coin100 coin){
        coins.add(coin);
    }

    // ドリンク購入可否

    public int deposit() {
        return coins.size() * 100;
    }

    public boolean isCorrectMenu(String drinkMenu) {
        if (drinkMenu.equals("a") || drinkMenu.equals("b")) {
            return true;
        }
        return false;
    }
}
