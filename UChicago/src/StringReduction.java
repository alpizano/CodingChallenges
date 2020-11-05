public class StringReduction {

    public int stringReduction(String s) {
        init(new char[26]);

        return 0;
    }

    public void init(char[] charArray) {
        char letter = 'a';

        for(int i=0; i<charArray.length; i++) {
            charArray[i] = letter++;
            //System.out.print(charArray[i] + " ");
        }
    }

    public static void main(String[] args) {
        StringReduction test = new StringReduction();
        test.stringReduction("cab");
        test.stringReduction("bcab");
        test.stringReduction("ccccc");


    }
}
