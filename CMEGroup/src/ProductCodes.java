import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCodes {
    public static void productMatcher(String s) {
       //final Pattern pattern = Pattern.compile("^([a-zA-Z0-9+]{1,3})([a-z])([0-9]{1,2}|[0-9]{4})");
       final Pattern pattern = Pattern.compile("([a-zA-Z0-9]{1,3})([a-zA-Z])([0-9]{1,2}|[0-9]{4})");


        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
           // System.out.println(matcher.group(0));
           // System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            //System.out.println(matcher.group(3));
        }
    }
    public static void main(String[] args) {
        // [product code] [month] [yearcode]
        // 1-3 chars/digits + 1 a-z char + 1,2, or 4 digits

        String test1 = "CU18";
        String test2 = "TYFZ19";
        String test3 = "USH9";

        ProductCodes.productMatcher(test1);
        ProductCodes.productMatcher(test2);
        ProductCodes.productMatcher(test3);




    }
}
