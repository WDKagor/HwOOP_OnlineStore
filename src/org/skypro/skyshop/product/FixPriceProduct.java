package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final int fixPrice = 115;

    public FixPriceProduct(String name, int fixPrice) {
        super(name);
    }

    @Override
    public int getPrice() {
        return fixPrice;
    }

    @Override
    public String toString() {
        return getName() + ": " + fixPrice + " руб.";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
