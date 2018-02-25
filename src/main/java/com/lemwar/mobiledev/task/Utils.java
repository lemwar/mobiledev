package com.lemwar.mobiledev.task;

import java.util.UUID;

public class Utils {

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}
