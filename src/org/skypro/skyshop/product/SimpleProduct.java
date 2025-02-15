package org.skypro.skyshop.product;

public class SimpleProduct extends Product  {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price > 1) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Цена не может ровняться 0");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
       return getName() + ": " + price + " руб.";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }
}
