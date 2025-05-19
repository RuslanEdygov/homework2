package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Searchable;

import java.sql.SQLOutput;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 95);
        SimpleProduct milk = new SimpleProduct("Молоко", 87);
        SimpleProduct bread = new SimpleProduct("Хлеб", 45);
        SimpleProduct cheese = new SimpleProduct("Сыр", 550);
        DiscountedProduct cheese1 = new DiscountedProduct("Сыр", 550, 50);
        FixPriceProduct shampoo = new FixPriceProduct("Шампунь");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);
        basket.addProduct(cheese1);
        basket.addProduct(shampoo);

        //basket.printBasket();

        basket.printContents();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice() + " руб.");

        basket.findProduct("Молоко");
        basket.findProduct("Кефир");

        basket.clear();

        basket.printContents();

        basket.findProduct("Хлеб");

        SearchEngine engine = new SearchEngine(10);
        engine.add(new SimpleProduct("Молоко", 60));
        engine.add(new DiscountedProduct("Сыр", 200, 20));
        engine.add(new FixPriceProduct("Мыло"));
        engine.add(new FixPriceProduct("Зубная щетка"));
        engine.add(new Article("Как выбрать молоко", "Учитывайте срок хранения и упаковку."));
        engine.add(new Article("Преимущества твёрдого мыла", "Мыло безопаснее для окружающей среды."));
        engine.add(new Article("Сыр: польза и вред", "Чрезмерное потребление может быть вредным."));

        System.out.println("Поиск по слову 'молоко':");
        for (Searchable result : engine.search("молоко")) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }

        System.out.println("\nПоиск по слову 'мыло':");
        for (Searchable result : engine.search("мыло")) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }

        System.out.println("\nПоиск по слову 'сыр':");
        for (Searchable result : engine.search("сыр")) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }

        System.out.println("\nПоиск по слову 'щетка':");
        for (Searchable result : engine.search("щетка")) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }


    }
}
