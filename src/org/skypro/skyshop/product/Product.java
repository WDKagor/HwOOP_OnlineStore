package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice ();

    public abstract String toString();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String typeTerm() {
        return "PRODUCT";
    }

    @Override
    public void getStringRepresentation() {
        Searchable.super.getStringRepresentation();
    }
}
