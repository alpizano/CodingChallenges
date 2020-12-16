import java.util.ArrayDeque;

public class Emersions {
    public int getEmersionsCount(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int length = input.length();
        int i=0;
        int downCount =0;
        int upCount =0;
        int emersionCount = 0;

        while(i < length) {
            if(input.charAt(i) == 'D') {
                stack.push(input.charAt(i));
                downCount++;
            }
            else if(input.charAt(i) == 'U' && downCount != upCount+1) {
                stack.push(input.charAt(i));
                upCount++;
            }
            else if(input.charAt(i) == 'U' && downCount == upCount+1) {
                stack.push(input.charAt(i));
                upCount++;
                emersionCount++;
            }
            i++;
        }

        return emersionCount;
    }
    public static void main(String[] args) {
        Emersions emersions = new Emersions();

        System.out.println("ex1. " + emersions.getEmersionsCount("UD"));
        System.out.println("ex2. "+emersions.getEmersionsCount("DUUUDUDD"));
        System.out.println("ex3. "+emersions.getEmersionsCount("DUDU"));

    }
}
