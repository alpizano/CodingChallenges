import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CounterfeitCurrency {
    public static void main(String[] args) {
        List<String> list = new ArrayList();

        String curr1 = "A201550B";
        String curr2 = "ABB19991000Z";
        String curr3 = "XYZ200019Z";
        String curr4 = "ERF200220";
        String curr5 = "SCD203010T";

        list.add(curr1);
        list.add(curr2);
        list.add(curr3);
        list.add(curr4);
        list.add(curr5);


        String valid = "^(?=.*[A-Z].*[A-Z].*[A-Z])" +
                "(?=.*[0-9].*[0-9].*[0-9].*[0-9])" +
                "(?=.*([0-9].*[0-9])|([0-9].*[0-9].*[0-9])|([0-9].*[0-9].*[0-9].*[0-9]))" +
                "(?=.*[A-Z])(?=\\S+$).{10,12}$";

        String stack = "^([A-Z](?!\\1)[A-Z](?!\\1|\\2)[A-Z])(?:1[9][0-9]{2}|20[01][0-9]|2019)[0-9]{2,4}[A-Z]$";

        String stack2 = "^([A-Z])(?!\\1)([A-Z])(?!\\1|\\2)[A-Z](?:19[0-9][0-9]|20[10][0-9])[0-9]{2,4}[A-Z]$";

        String validYear = "(?=.*([0-9].*[0-9])|([0-9].*[0-9].*[0-9])|([0-9].*[0-9].*[0-9].*[0-9]))";

//        for(String val: list) {
//            System.out.print("current value is: " + val);
//            if(val.matches(stack2)) {
//                System.out.print(" VALID");
//            }
//            else{
//                System.out.print(" INVALID");
//            }
//            System.out.println();
//        }

        System.out.println("-----------------------");

        // 10, 20, 500 ,100
        String year1 = "";

        Pattern pattern = Pattern.compile("^(?=(.*[A-Z].*[A-Z].*[A-Z]))(?=.*([0-9].*[0-9].*[0-9].*[0-9]))(?=.*([0-9].*[0-9])|([0-9].*[0-9].*[0-9])|([0-9].*[0-9].*[0-9].*[0-9]))(?=.*[A-Z])(?=\\S+$).{10,12}?");
        Pattern pattern2 = Pattern.compile("([A-Z]{3,3})([0-9]{4,4})([0-9]{2,2}|[0-9]{3,3}|[0-9]{4,4})([A-Z]{1})");
        Matcher matcher = pattern.matcher(curr2);
        Matcher matcher2 = pattern2.matcher(curr2);

        Pattern patternTest = Pattern.compile("[A-Z]{2}");
        Matcher matcherTest = patternTest.matcher("ABBB");

        //System.out.println("Matcher result is: " + matcher.find());

//        if(matcher.find()) {
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            System.out.println(matcher.group(3));
//            System.out.println(matcher.group(4));
//        }
        System.out.println("-----------------------");
//        if(matcher2.find()) {
//            System.out.println("matcher2");
//            System.out.println(matcher2.group(0));
//            System.out.println(matcher2.group(1));
//            System.out.println(matcher2.group(2));
//            System.out.println(matcher2.group(3));
//        }
        System.out.println("-----------------------");
//        if(matcherTest.find()) {
//            System.out.println("matcherTest");
//            System.out.println(matcherTest.group(0));
//        }

        System.out.println("-----------------------");


        String regex = "\\A(([A-Z])(?!\\2)([A-Z])(?!\\2|\\3)[A-Z])(19[0-9][0-9]|20[10][0-9])([0-9]{2,4})([A-Z])\\Z";
        Pattern p = Pattern.compile(regex);
//        "XYZ200019Z"
        List<String> inputs = new ArrayList<>(Arrays.asList("5","A201550B","ABB19991000Z","ERF200220","SCD203010T","ABC20191000Z"));

//        Pattern p = Pattern.compile("([A-Z])(?!\\2)([A-Z])(?!\\2|\\3)[A-Z](19[0-9][0-9]|20[10][0-9])([0-9]{2,4})([A-Z])"); // working
//        Pattern p = Pattern.compile("^([A-Z])(?!\\1)([A-Z])(?!\\1|\\2)[A-Z](?:19[0-8][0-9]|199[0-9]|200[0-9]|201[0-9])([0-9]{2,4})([0-9])$");
//        Pattern p = Pattern.compile("^(?=.*[A-Z]{3,})(?=.*[0-9]{4,})(?=.*[0-9]{2,4})(?=.*[A-Z]{1,}){10,}?");

        // 2019 is false => should be true
        // 2018 is true
        // 1900 is true
        // 1899 is false

//        Matcher m = p.matcher("AVG190410T");
        int sum = 0;
        Set<Integer> set = new HashSet<>(Arrays.asList(10,20,50,100,200,500,1000));

//        System.out.println("CAPITAL ONE TEST IS: " + m.find());

//        inputs.stream().map( i -> {
//                Matcher m = p.matcher(i);
//                if (m.find()) {
//                    sum = sum + Integer.parseInt(m.group(5));
//                }
//        });
//
//                inputs.stream().filter(i -> p.matcher(i).find()).map
//
//       // for(String value: inputs) {
//            System.out.println("Current value is: " + value);
//            Matcher m = p.matcher(value);

//            if(m.find()) {
                // group 5 only if 4 digit currency
               // if(set.contains(m.group(5))) {
//                    sum += sum + Integer.parseInt(m.group(5));
//                    System.out.println("Current sum is: " + sum+ " for input: " + m.group(0));
                //}
            }
       // }


}
