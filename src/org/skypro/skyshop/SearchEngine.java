package org.skypro.skyshop;

import org.skypro.skyshop.exeptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List <Searchable> searchables;

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    public void add(Searchable item) {
        searchables.add(item);
    }

    public List<Searchable> search(String query) {
        List <Searchable> results = new ArrayList<>();
        for (Searchable item : searchables) {
            if (item != null && item.searchTerm().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }

    public static Searchable findBestMatch(String search, List<Searchable> items) throws BestResultNotFound {
        if (search == null || search.isEmpty() || items == null || items.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            int count = getSearchTerm(item.searchTerm(), search);

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    // Метод для подсчёта количества вхождений подстроки в строке
    private static int getSearchTerm(String text, String search) {
        if (text == null || search == null || search.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }

        return count;
    }
}
