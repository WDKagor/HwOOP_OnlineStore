package org.skypro.skyshop.exeptions;

public class BestResultNotFound extends RuntimeException {
    public BestResultNotFound() {
    }

    public BestResultNotFound(String searchQuery) {
        super("Подходящий результат для запроса " + searchQuery + " не найден");
    }

    public BestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BestResultNotFound(Throwable cause) {
        super(cause);
    }

    public BestResultNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
