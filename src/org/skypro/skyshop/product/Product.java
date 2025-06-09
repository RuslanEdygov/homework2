package org.skypro.skyshop.product;

public abstract class Product implements Searchable{
    private final String name;


    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть или состоять только из пробелов");
        }
        this.name = name;
    }

//    public String getName() {
//
//        return name;
//    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }
    @Override
    public String getContentType() {
        return "Продукт";
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract String toString();


}
