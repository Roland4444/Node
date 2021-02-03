package util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Trimmer {
    public static String trimWeight(String input){
        var trimmed = input.substring(2, 10);
        return trimApply(trimmed);
    };


    public static String hexToString(String hex){
        return trimApply(String.valueOf(Integer.parseInt(hex.substring(6,11).replace(" ",""), 16)));
    }

    public static String trimApply(String input){
        BigDecimal bd = new BigDecimal(input);
        BigDecimal result  =  bd.setScale(2, RoundingMode.HALF_UP);
        return String.valueOf(result);
    };
}
