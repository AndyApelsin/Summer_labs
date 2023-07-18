package com.andyegor.helper;

public class ValidationHelper {
    public static <T> void checkForNull(T obj, String message){
        if(obj == null){
            throw new RuntimeException(message);
        }
    }
//проверки на позитивность рабоатют и для примимтивных типов
    public static void checkFloatPositivity(Float obj, String message){
        if(obj <= 0){
            throw new RuntimeException(message);
        }
    }

    public static void checkIntegerPositivity(Integer obj, String message){
        if(obj <= 0){
            throw new RuntimeException(message);
        }
    }

    public static void checkLongPositivity(Long obj, String message){
        if(obj <= 0){
            throw new RuntimeException(message);
        }
    }

    public static void checkStringNotEmpty(String obj, String message){
        if(obj.equals("")){
            throw new RuntimeException(message);
        }
    }
    public static void checkStringSize(String obj, String message){
        if(obj.length() >= 629){
            throw new RuntimeException(message);
        }
    }
}
