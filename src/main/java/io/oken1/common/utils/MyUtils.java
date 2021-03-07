package io.oken1.common.utils;

import java.util.UUID;

public class MyUtils {
    public static String myUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static String myShortUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 7);
        if (Math.random() > 0.5) {
            uuid = uuid.toUpperCase();
        }
        return uuid;
    }
}
