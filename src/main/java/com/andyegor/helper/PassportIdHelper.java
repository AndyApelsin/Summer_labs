package com.andyegor.helper;

import java.util.HashSet;
import java.util.Set;

public class PassportIdHelper {
    private static Set<String> passportIdSet = new HashSet<>();
    public static boolean checkPassportIdLength(String passportId){
        return passportId.length() >=6;
    }
    public static void checkPassportIdLengthXml(String passportId, String message){
        if(!(passportId.length() >= 6)){
            throw new RuntimeException(message);
        }
    }
    public static boolean addPassportId(String passportId)  {
        return passportIdSet.add(passportId);
    }
    public static void addPassportIdXml(String passportId, String message){
        if(!passportIdSet.add(passportId)){
            throw new RuntimeException(message);
        }
    }
}
