package io.oken1.common.utils;

import java.util.UUID;

public class MyUtils {
    public static String myUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
