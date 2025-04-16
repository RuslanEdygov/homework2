package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.sql.SQLOutput;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 95);
        Product milk = new Product("Молоко", 87);
        Product bread = new Product("Хлеб", 45);
        Product cheese = new Product("Сыр", 550);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(cheese);

        basket.printContents();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice() + " руб.");

        basket.findProduct("Молоко");
        basket.findProduct("Кефир");

        basket.clear();

        basket.printContents();

        basket.findProduct("Хлеб");
    }
}
