package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

import static org.skypro.skyshop.SearchEngine.findBestMatch;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = null;
        SimpleProduct potatos = null;
        DiscountedProduct turkeyFillet = null;
        SimpleProduct cucumber = null;
        SimpleProduct tomatoes = null;
        SimpleProduct pamelo = null;
        SimpleProduct eggs = null;
        SimpleProduct salad = null;
        DiscountedProduct quinoa = null;

        try {
            apple = new SimpleProduct("Apple", 256);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
        try {
            potatos = new SimpleProduct("Potatos", 85);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
        try {
            turkeyFillet = new DiscountedProduct("Turkey fillet", 498, 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
        try {
            cucumber = new SimpleProduct("Cucumber", 130);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
        try {
            tomatoes = new SimpleProduct("Tomatoes", 326);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
        try {
            pamelo = new SimpleProduct("Pamelo", 432);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
        try {
            eggs = new SimpleProduct("Eggs", 93);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
        try {
            salad = new SimpleProduct("Salad", 148);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
        try {
            quinoa = new DiscountedProduct("Quinoa", 252, 16);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продкта: " + e.getMessage());
        }
            FixPriceProduct kefir = new FixPriceProduct("Kefir");

            ProductBasket basket1 = new ProductBasket();

            if (apple != null) {
                basket1.add(apple);
            }
            if (quinoa != null) {
                basket1.add(quinoa);
            }
            if (turkeyFillet != null) {
                basket1.add(turkeyFillet);
            }

            basket1.add(kefir);

            if (eggs != null) {
                basket1.add(eggs);
            }
            if (cucumber != null) {
                basket1.add(cucumber);
            }
            if (salad != null) {
                basket1.add(salad);
            }

        System.out.println(" ");

            basket1.printListBasket();

            basket1.checkBasketPrint("Salad");

            basket1.checkBasketPrint("Pamelo");

        System.out.println(" ");

            basket1.clearBasket();

            basket1.printListBasket();

            basket1.checkBasketPrint("Apple");

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

            System.out.println("\n" + Arrays.toString(engine.search("Tomatoes")));
            System.out.println(Arrays.toString(engine.search("Kefir")));

            Searchable[] articles = {article01, article02, article03, article04};
            String queryToday = "Kefir";

            System.out.println("\n" + "Лучшая статья по запросу <" + queryToday + ">:" + "\n" +findBestMatch(queryToday, articles));


    }
}