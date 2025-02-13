package org.skypro.skyshop;

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

    public Searchable[] search(String query) { //Метод будет возвращать массив Searchable[], принимая в качестве аргумента строковое значение с именем query
        Searchable[] results = new Searchable[5]; // Создаем массив results, где будем собирать результаты, и как раз его и будет возвращать этот метод
        int foundCount = 0; // Создаем счётчик, который будет считать количество найденных совпадений. Присваем нулевое значение для начала отсчёта

        for (Searchable item : searchables) { //Используем цикл foreach - для каждого значения item типа Searchable в коллекции searchables сделать ниже следующее
            if (item != null && item.searchTerm().contains(query)) { // Если значение item, полученное с помощью метода searchTerm() не равно нулю и соответствует сигнатурой (с учетом регистра) запросу query,
                results[foundCount++] = item; // тогда в массив results в элемент, на единицу бОльший текущего значения счётчика foundCount, добавляем найденный элемент item
                if (foundCount == 5) { // Если текущее значение foundCount равно 5, значит массив результаток заполнен
                    break; // и мы прекращаем поиск
                }
            }
        }
        return results; // После этого возвращаем заполненный результатами поиска массив results. Он может содержать null, т.к. может быть найдено менее 5-ти соответствий запросу.
    }
}
