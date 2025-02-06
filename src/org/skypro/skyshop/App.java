package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        SimpleProduct apple = new SimpleProduct("Apple", 256);
        SimpleProduct potatos = new SimpleProduct("Potatos", 85);
        DiscountedProduct turkeyFillet = new DiscountedProduct("Turkey fillet", 498, 25);
        SimpleProduct cucumber = new SimpleProduct("Cucumber", 130);
        SimpleProduct tomatos = new SimpleProduct("Tomatos", 326);
        SimpleProduct pamelo = new SimpleProduct("Pamelo", 432);
        SimpleProduct eggs = new SimpleProduct("Eggs", 93);
        SimpleProduct salad = new SimpleProduct("Salad", 148);
        DiscountedProduct quinoa = new DiscountedProduct("Quinoa", 252, 16);
        FixPriceProduct kefir = new FixPriceProduct("Kefir");

        ProductBasket basket1 = new ProductBasket();

        basket1.add(apple);
        basket1.add(quinoa);
        basket1.add(turkeyFillet);
        basket1.add(kefir);
        basket1.add(eggs);
        basket1.add(cucumber);
        basket1.add(salad);

        basket1.printBasket();

        basket1.checkBasket("Salad");

        basket1.checkBasket("Pamelo");

        basket1.clearBasket();

        basket1.printBasket();

        basket1.checkBasket("Apple");
    }

}