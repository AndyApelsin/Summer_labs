package com.andyegor.helper;

public class ValidationHelper {
    public static <T> boolean checkNotNull(T obj){
        return obj != null;
    }
//проверки на позитивность рабоатют и для примимтивных типов
//    public static void checkFloatPositivity(Float obj, String message){
//        if(obj <= 0){
//            throw new RuntimeException(message);
//        }
//    }
//
//    public static void checkIntegerPositivity(Integer obj, String message){
//        if(obj <= 0){
//            throw new RuntimeException(message);
//        }
//    }
//
//    public static void checkLongPositivity(Long obj, String message){
//        if(obj <= 0){
//            throw new RuntimeException(message);
//        }
//    }
    public static <T extends Number> boolean checkNumberPositivity (T obj){
        return (obj.doubleValue() > 0);
    }

    public static boolean checkStringNotEmpty(String obj){
        return obj != "";
    }
    public static boolean checkStringSize(String obj){
        return obj.length() <= 629;
    }
    public static boolean isDigit (String s){
        try {
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isInteger (String s){
        try {
            Long.parseLong(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static <T> void checkNotNullXml(T obj, String message){
        if(obj == null){
            throw new RuntimeException(message);
        }
    }
    public static <T extends Number> void checkNumberPositivityXml (T obj, String message){
        if(obj.doubleValue() <= 0){
            throw new RuntimeException(message);
        }
    }
    public static void checkStringNotEmptyXml (String obj, String message) {
        if(obj.equals("")){
            throw new RuntimeException(message);
        }
    }
    public static void checkStringSizeXml (String obj, String message){
        if(obj.length() > 629){
            throw new RuntimeException(message);
        }
    }
}
