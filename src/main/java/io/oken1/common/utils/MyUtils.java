package io.oken1.common.utils;

import org.apache.commons.lang.StringUtils;

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

    public static String nvl(String str1, String str2) {
        return str1 == null ? str2 : str1;
    }

    public static String nvl(String str1, String str2, String str3) {
        return str1 == null ? str3 : str2;
    }
}
