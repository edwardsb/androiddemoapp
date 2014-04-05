package com.example.mydemoapp.app;

/**
 * Created by edwardsb on 4/5/14.
 */
public class ConvertUtils {

    public static float convertFtoC(float f){
        return ((f - 32) * 5/9);
    }

    public static float convertCtoF(float c){
        return ((c * 9) / 5) + 32;
    }
}
