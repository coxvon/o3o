package org.cv.web.model;

public record R<T>(String code, String msg, T data) {
    public static final String SUCCESS = "0000";
    public static final String WARN = "5555";
    public static final String FAILURE = "9999";

    public static <T> R<T> of(String code, String msg, T data) {
        return new R<>(code, msg, data);
    }
    public static <T> R<T> ok() {
        return ok(null);
    }
    public static <T> R<T> ok(T data) {
        return ok(SUCCESS, data);
    }
    public static <T> R<T> ok(String msg) {
        return of(SUCCESS, msg, null);
    }
    public static <T> R<T> ok(String msg, T data) {
        return of(SUCCESS, msg, data);
    }
    public static <T> R<T> fail(String msg) {
        return of(FAILURE, msg, null);
    }
    public static <T> R<T> warn(String msg, T data) {
        return of(WARN, msg, data);
    }
    public static <T> R<T> warn(String msg) {
        return warn(msg, null);
    }

}
