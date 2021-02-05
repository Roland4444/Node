package util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trimmer {
    public static String trimWeight(String input){
        var trimmed = input.substring(2, 10);
        return trimApply(trimmed);
    };


    public static String hexToString(String weight){
        if (weight==null)
            return "";
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
        String hook=input.replace("=","");
        BigDecimal bd = new BigDecimal(hook);
        BigDecimal result  =  bd.setScale(2, RoundingMode.HALF_UP);
        return String.valueOf(result);
    };


    public static String parseWeight(String weight) {
        Pattern p = Pattern.compile("\\=.*[0-9.]{5,6}+\\$");
        Matcher m = p.matcher(weight);
        if(m.find()){
            return weight.substring(m.start(),m.end()).replaceAll("[^0-9]","");
        }
        return "";
    }


    public static String parse3002(String weight){
        return new StringBuilder().append(weight, weight.indexOf("=")+1, weight.indexOf("=")+ 9).reverse().toString();
    }

}
