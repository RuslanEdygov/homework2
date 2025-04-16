package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int count = 0;

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
            System.out.println("Добавлен: " + product);
        } else {
            System.out.println("Невозможно добавить продукт (" + product + ")");
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }


    public void printContents() {
        if (count == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Содержимое корзины:");
            for (int i = 0; i < count; i++) {
                System.out.println(" - " + products[i]);

            }
        }
    }

    public void findProduct(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Товар найден: " + products[i]);
                return;
            }
        }
        System.out.println("Товар \"" + name + "\" не найден в корзине");
    }


    public void clear() {
        count = 0;
        System.out.println("Корзина очищена");
    }
}

