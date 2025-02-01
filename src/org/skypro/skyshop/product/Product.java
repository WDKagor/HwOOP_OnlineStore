package org.skypro.skyshop.product;

public class Product {
    private String namePrd;
    private int pricePrd;

    public Product(String namePrd, int pricePrd) {
        this.namePrd = namePrd;
        this.pricePrd = pricePrd;
    }

    public String getNamePrd() {
        return namePrd;
    }

    public int getPricePrd() {
        return pricePrd;
    }

    @Override
    public String toString() {
        return namePrd + ": " + pricePrd + " руб.";
    }
}
