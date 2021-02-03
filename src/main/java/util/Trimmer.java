package util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Trimmer {
    public static String trimWeight(String input){
        var trimmed = input.substring(2, 10);
        return trimApply(trimmed);
    };


    public static String hexToString(String weight){
        if (weight != null) {
            String[] results = weight.split(" ");
            if (results.length >= 4) {
                String hx = results[3] + results[2];
                weight = String.valueOf((Integer.parseInt(hx, 16)) * 0.1);
            }
        }
        return trimApply(weight);
    }

    public static String trimApply(String input){
        BigDecimal bd = new BigDecimal(input);
        BigDecimal result  =  bd.setScale(2, RoundingMode.HALF_UP);
        return String.valueOf(result);
    };
}
