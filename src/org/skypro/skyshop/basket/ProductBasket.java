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

    public int totalCost() {
        int total = 0;
        for (Product product : basket) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public int specialProducts() {
        int count = 0;
        for (Product product : basket) {
            if (product != null) {
                if (product.isSpecial()) {
                    count++;
                }
            }

        }
        return count;
    }

    public void printBaskit() {
        if (indexInArray == 0) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product: basket) {
                if (product != null) {
                    System.out.println(product);
                }
            }
        }
        System.out.println("Итого: " + totalCost() + " руб.");
        System.out.println("Специальные продукты: " + specialProducts() + " шт.");
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
