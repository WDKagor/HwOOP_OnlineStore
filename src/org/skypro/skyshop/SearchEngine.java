package org.skypro.skyshop;

import org.skypro.skyshop.exeptions.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchables.length) {
            searchables[count++] = item;
        } else {
            System.out.println("Невозможно добавить " + item + ", т.к. массив заполнен!");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (Searchable item : searchables) {
            if (item != null && item.searchTerm().contains(query)) {
                results[foundCount++] = item;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
    /*19 Метод будет возвращать массив Searchable[], принимая в качестве аргумента строковое значение с именем query
    20 Создаем массив results, где будем собирать результаты, и как раз его и будет возвращать этот метод
    21 Создаем счётчик, который будет считать количество найденных совпадений. Присваем нулевое значение для начала отсчёта
    23 Используем цикл foreach - для каждого значения item типа Searchable в коллекции searchables сделать ниже следующее
    24 Если значение item, полученное с помощью метода searchTerm() не равно нулю и соответствует сигнатурой (с учетом регистра) запросу query,
    25 тогда в массив results в элемент, на единицу бОльший текущего значения счётчика foundCount, добавляем найденный элемент item
    26 Если текущее значение foundCount равно 5, значит массив результаток заполнен
    27 и мы прекращаем поиск
    28 После этого возвращаем заполненный результатами поиска массив results. Он может содержать null, т.к. может быть найдено менее 5-ти соответствий запросу.*/

    public static Searchable findBestMatch(String search, Searchable[] items) throws BestResultNotFound {
        if (search == null || search.isEmpty() || items == null || items.length == 0) {
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
