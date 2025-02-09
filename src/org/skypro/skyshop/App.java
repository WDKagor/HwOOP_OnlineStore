package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        SimpleProduct apple = new SimpleProduct("Apple", 256);
        SimpleProduct potatos = new SimpleProduct("Potatos", 85);
        DiscountedProduct turkeyFillet = new DiscountedProduct("Turkey fillet", 498, 25);
        SimpleProduct cucumber = new SimpleProduct("Cucumber", 130);
        SimpleProduct tomatoes = new SimpleProduct("Tomatoes", 326);
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

        basket1.checkBasketPrint("Salad");

        basket1.checkBasketPrint("Pamelo");

        basket1.clearBasket();

        basket1.printBasket();

        basket1.checkBasket("Apple");

        Article article01 = new Article("Benefits of kefir", "Kefir is healthy because it contains beneficial lactic acid bacteria, which help not only kefir itself, but also other foods to be well digested.");
        Article article02 = new Article("Turkey with Tomatoes", "It is recommended to serve turkey with Tomatoes as a hot dish with some side dish..");
        Article article03 = new Article("Nutritional value of cucumber", "Fresh cucumber is 95% water, 4% carbohydrates, 1% protein and contains a small amount of fat. It has a low content of microelements: it is notable only for its content of vitamin K.");
        Article article04 = new Article("Types of Quinoa", "White, black and red quinoa are common. You can also find tri-color quinoa on sale, when different colored seeds are mixed in one package.");

        SearchEngine engine = new SearchEngine(10);
        engine.add(kefir);
        engine.add(potatos);
        engine.add(turkeyFillet);
        engine.add(tomatoes);
        engine.add(salad);
        engine.add(pamelo);
        engine.add(article01);
        engine.add(article02);
        engine.add(article03);
        engine.add(article04);
        engine.add(pamelo);
        engine.add(quinoa);

        System.out.println(Arrays.toString(engine.search("Tomatoes")));
        System.out.println(Arrays.toString(engine.search("Kefir")));
        System.out.println(Arrays.toString(engine.search("Quinoa")));
    }
}