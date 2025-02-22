package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> basket;

    public ProductBasket() {
        this.basket = new LinkedList<>();
    }

    public void add(Product product) {
        try {
            basket.add(product);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Недопустимое название продукта");
        }

    }

    public void printListBasket() {
        Iterator<Product> iterator = basket.iterator();
        int total = 0;
        int count = 0;
        if (!iterator.hasNext()) {
            System.out.println("В корзине пусто");
        } else {
            while (iterator.hasNext()) {
                Product product = iterator.next();
                System.out.println(product);
                total += product.getPrice();
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        System.out.println("Итого: " + total + " руб.");
        System.out.println("Специальные продукты: " + count + " шт." + "\n");
    }

    // Метод проверяет наличие продукта в Корзине и выводит результат проверки в консоль
    public void checkBasketPrint(String name) {
        boolean found = false;
        for (Product product : basket) {
            if (product != null && product.getName().equals(name)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println(name + " есть в корзине!");
        } else {
            System.out.println(name + " нет в корзине");
        }
    }


    public void clearBasket() {
        basket.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>(); // Список удалённых продуктов

        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product); // Добавляем в список удалённых продуктов
                iterator.remove(); // Удаляем из корзины
            }
        }

        return removedProducts;
    }
}