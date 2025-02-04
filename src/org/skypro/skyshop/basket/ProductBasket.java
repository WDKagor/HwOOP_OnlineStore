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

    public void add (Product product) {
        if (indexInArray < basket.length) {
            basket[indexInArray] = product;
            indexInArray ++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public void printBasket() {
        int total = 0;
        int count = 0;
        if (indexInArray == 0) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product: basket) {
                if (product != null) {
                    System.out.println(product);
                    total += product.getPrice();
                    if (product.isSpecial()) {
                        count++;
                    }
                }
            }
        }
        System.out.println("Итого: " + total + " руб.");
        System.out.println("Специальные продукты: " + count + " шт.");
    }

    public boolean checkBasket(String name) {
        for (Product product: basket) {
            if (product != null) {
                if (product.getName().equals(name)) {
                return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(basket, null);
        indexInArray = 0;
    }
}
