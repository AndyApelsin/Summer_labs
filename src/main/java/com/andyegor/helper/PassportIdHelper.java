package com.andyegor.helper;

import java.util.HashSet;
import java.util.Set;

public class PassportIdHelper {
    private static Set<String> PassportIdSet = new HashSet<>();
    public static void addPassportId(String passportId) {
        if (!PassportIdSet.add(passportId)) {
            throw new RuntimeException("passport id is not unique");
        }
    }
}
