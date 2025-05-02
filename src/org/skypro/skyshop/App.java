package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;

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
    }
}
