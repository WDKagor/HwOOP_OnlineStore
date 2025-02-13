package org.skypro.skyshop;

public interface Searchable {
    String searchTerm();
    String typeTerm();
    default void getStringRepresentation() {
        System.out.println(searchTerm() + " - " + typeTerm());
    }
}
