package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        Product apple = new Product("Apple", 256);
        Product potatos = new Product("Potatos", 85);
        Product turkeyFillet = new Product("Turkey fillet", 498);
        Product cucumber = new Product("Cucumber", 130);
        Product tomatos = new Product("Tomatos", 326);
        Product pamelo = new Product("Pamelo", 432);
        Product eggs = new Product("Eggs", 93);
        Product salad = new Product("Salad", 148);
        Product quinoa = new Product("Quinoa", 252);
        Product kefir = new Product("Kefir", 76);

        ProductBasket basket1 = new ProductBasket();

        basket1.add(apple);
        basket1.add(cucumber);
        basket1.add(turkeyFillet);
        basket1.add(salad);
        basket1.add(eggs);
        basket1.add(quinoa);
        basket1.add(kefir);

        basket1.printBaskit();

        basket1.totalCost();

        basket1.checkBasket("Salad");

        basket1.checkBasket("Pamelo");

        basket1.clearBasket();

        basket1.printBaskit();

        basket1.totalCost();

        basket1.checkBasket("Apple");
    }

}