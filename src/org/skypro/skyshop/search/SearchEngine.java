package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

public class SearchEngine {
    private final Searchable[] data;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.data = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size < data.length) {
            data[size++] = item;
        } else {
            System.out.println("Поисковой индекс переполнен, элемент не добавлен: " +
                    item.getName());
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (data[i].getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count++] = data[i];
                if (count == 5) break;
            }
        }
        return results;

    }
}

