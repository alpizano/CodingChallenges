import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Matcher m1 = Pattern.compile("([A-Z])+").matcher("ABB19991000Z");
        Matcher m2 = Pattern.compile("(([A-Z])(?!\\2)([A-Z])(?!\\2|\\3)[A-Z])").matcher("ABB");

        if(m1.find()) {
            System.out.println(m1.group(0));
            System.out.println(m1.group(1));
//            System.out.println(m1.group(2));
        }

        if(m2.find()) {
            System.out.println(m2.group(0));
            System.out.println(m2.group(1));
//            System.out.println(m1.group(2));
        }

    }
}
