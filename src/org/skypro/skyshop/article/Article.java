package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String typeTerm() {
        return "ARTICLE";
    }

    @Override
    public void getStringRepresentation() {
        Searchable.super.getStringRepresentation();
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }
}
