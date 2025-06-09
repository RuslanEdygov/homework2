package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

public class SearchEngine {
    private Searchable[] items;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size < items.length) {
            items[size++] = item;
        } else {
            System.out.println("Поисковой индекс переполнен, элемент не добавлен: " +
                    item.getName());
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (items[i].getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count++] = items[i];
                if (count == 5) break;
            }
        }
        return results;

    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound(search);
        }
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : items) {
            if (item == null) continue;
            String searchTerm = item.getSearchTerm().toLowerCase();
            int count = countOccurrencs(searchTerm, search.toLowerCase());

            if (count > maxOccurrences) {
                maxOccurrences = count;
                bestMatch = item;
            }
        }
        if (bestMatch == null || maxOccurrences == 0) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    private int countOccurrencs(String text, String pattern) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index += pattern.length();
        }
        return count;
    }
}

