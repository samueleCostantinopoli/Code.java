package com.example.fitnesshelp.bean;

import com.example.fitnesshelp.entities.Purchase;

public class BeanPurchase {

    private Purchase purchase;
    public BeanPurchase(Purchase newPurchase) {
        this.purchase = newPurchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
