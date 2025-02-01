package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] basket;
    private int indexInArray;

    public ProductBasket() {
        this.indexInArray = 0;
        this.basket = new Product[5];
    }

    public void addPrd (Product product) {
        if (indexInArray < basket.length) {
            basket[indexInArray] = product;
            indexInArray ++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int totalCost() {
        int total = 0;
        for (int i = 0; i < indexInArray; i++) {
            total += basket[i].getPricePrd();
        }
        return total;
    }

    public void printBaskit() {
        if (indexInArray == 0) {
            System.out.println("В корзине пусто");
        } else {
            for (int i = 0; i < basket.length; i++) {
                System.out.println(basket[i].toString());
            }
        }
        System.out.println("Итого: " + totalCost());
    }

    public boolean checkBasket(String namePrd) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i].getNamePrd().equals(namePrd)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
        indexInArray = 0;
    }
}
