package org.skypro.skyshop.exeptions;

import org.skypro.skyshop.Searchable;

public class EmptyQueryOrSearchScope extends RuntimeException{
    public EmptyQueryOrSearchScope() {
    };

    public EmptyQueryOrSearchScope(String searchQuery) {
        super("Запрос " + searchQuery + " или поле поиска пусты");
    }

    public EmptyQueryOrSearchScope(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyQueryOrSearchScope(Throwable cause) {
        super(cause);
    }

    public EmptyQueryOrSearchScope(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
