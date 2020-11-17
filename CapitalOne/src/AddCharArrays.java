public class AddCharArrays {
    public char[] add(char[] arr1, char[] arr2) {
        String s1 = String.valueOf(arr1);
        String s2 = String.valueOf(arr2);
        int carry = 0;
        char[] answer;

        if(s1.length() > s2.length()) {
            s2 = String.format("%0"+ s1.length() +"d", Integer.parseInt(s2));
            answer = new char[s1.length()];
        }
        else {
            s1 = String.format("%0"+ s2.length() +"d", Integer.parseInt(s1));
            answer = new char[s1.length()];
        }

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        for(int i=s1.length()-1, j=s2.length()-1; i>=0; i--, j--) {
            // char -> int (no ascii)
            int sum = Character.getNumericValue(s1.charAt(i)) + Character.getNumericValue(s2.charAt(j)) + carry;
            int digit = sum % 10;
            carry = sum / 10;

            // int -> char (no ascii)
            answer[i] = Character.forDigit(digit,10);
        }

        if(carry == 1) {
            char[] overflow = new char[answer.length+1];
            overflow[0] = '1';
            for(int i=1; i<overflow.length; i++) {
                overflow[i] = answer[i-1];
            }
            return overflow;
        }

        return answer ;
    }

    public void print(char[] nums) {
        for(char val : nums) {
            System.out.print(val + " ");
        }
    }
    public static void main(String[] args) {
        AddCharArrays test = new AddCharArrays();
       // test.print(test.add(new char[]{'3','5','9'}, new char[]{'1','2','8','4'})); // answer 1643

        test.print(test.add(new char[]{'8','3','4'}, new char[]{'9','2','1','4'})); //    10048

        int intVal = 6;
        char charVal = (char) intVal;

    }
}
