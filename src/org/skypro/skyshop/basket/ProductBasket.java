package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new LinkedHashMap<>();
    }

    // Метод добавляет продукт Корзину, предварительно проверив, если уже в Корзине
    // продукты с таким названием.
    public void add(Product product) {
        basket.putIfAbsent(product.getName(), new ArrayList<>());
        basket.get(product.getName()).add(product);
    }
    /*17* Получаем список продуктов в Корзине по ключу (названию прдукта) с помощью метода putIfAbsent(),
        который создаёт новый список продуктов ArrayList<>() с указанным названием, если не находит его в Корзине.
        Метод putIfAbsent() только проверяет Корзину на наличие указанного названия продукта, но не добавляет цену
        этого продукта в список ArrayList<>().

    18* С помощью вызова двух методов get() и add() добавляем продукт с ценой в список продуктов с таким же названием.
        get() - принимает в качестве аргумента наименование продукта product.getName(), чтобы определить список,
                в который добавить указанный продукт;
        add() - принмиает в качестве аргумента объект класса-наследника Product со всем полями класса*/

    // Метод проверяет пуста ли Корзина, если не пуста, то выводит на печать её содержимое,
    // общую стоимость продуктов в Корзине и количество специальных продуктов
   /* 44* В условии цикла for-each используем внутренний интерфейс Map.Entry< K, V>.
        Использование LinkedHashMap в for-each невозможно, так как он сам по себе не итерируемый,
        а Map.Entry< K, V> позволяет напрямую обращаться к отдельным элементам LinkedHashMap
        с помощью метода entrySet().*/
    public void printBasket() {
        int total = 0;
        int count = 0;
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        System.out.println("Содержимое корзины:");
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            String name = entry.getKey();
            List<Product> products = entry.getValue();


            System.out.println(name + ":");
            for (Product product : products) {
                System.out.println("  - " + product);
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
    public void checkBasketPrint (String name) {
        boolean found = false;
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            List<Product> products = entry.getValue();
            for (Product product : products) {
                if (product != null && product.getName().equals(name)) {
                    found = true;
                    break;
                }
            }
        }
            if (found) {
            System.out.println(name + " есть в корзине!");
            } else {
            System.out.println(name + " нет в корзине!");
            }
    }

    // Метод очищает Корзину
    public void clearBasket() {
        basket.clear();
    }
}
