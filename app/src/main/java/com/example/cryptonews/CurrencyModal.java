package com.example.cryptonews;

import android.widget.Button;

public class CurrencyModal {
    // variable for currency name,
    // currency symbol and price.
    private String name;
    private String symbol;
    private double price;
    Button button;

    public CurrencyModal(String name, String symbol, double price, Button button) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.button = button;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void add(CurrencyModal currencyModal) {
    }
}
