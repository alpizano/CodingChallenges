
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S);
        System.out.println("length: " + sb.length());
        System.out.println(sb.toString());

        for(int i=sb.length()-1; i>=0; i--) {
            if(sb.charAt(i) == '-') {
                sb.deleteCharAt(i);
            }
            else {
                System.out.println("i: "  +i);
                sb.setCharAt(i,Character.toUpperCase(sb.charAt(i)));
            }
        }
        System.out.println(sb.toString());

        for(int i=sb.length(); i>=0; i=i-K) {
            if(i != sb.length() && i != 0) {
                sb.insert(i,"-");
            }
        }

        System.out.println(sb.toString());


//        String[] strArray = S.split("");
//        List<String> strList = new ArrayList(Arrays.asList(strArray));

//        strList = strList.stream().filter(i -> !i.equals("-")).collect(Collectors.toList());
//        String[] strArray2 = new String[strList.size()];
//         strArray2 = strList.toArray(strArray2);

//        Iterator<String> it = strList.iterator();


//        int index = strList.size()-1;
//        for(String val : strList) {
//            strList.add("-");
//            index = index -K ;
//        }

//        for(int i=strArray2.length-1; i>=0; i=i-K) {
//            strArray[i] =
//        }

//        IntStream.range(0, strList.size()-1).forEach( i -> {
//            System.out.println(strList.get(i));
//        });

//        AtomicInteger count = new AtomicInteger(strList.size()-1);
//        Collections.reverse(strList);
//
//        strList.stream().forEach( i -> {
//            System.out.println(i));
//
//        });


//        System.out.println(strList);
        return sb.toString();

    }

    public static void main(String[] args) {
        LicenseKeyFormatting test = new LicenseKeyFormatting();
        test.licenseKeyFormatting("5F3Z-2e-9-w",4);
    }
}
