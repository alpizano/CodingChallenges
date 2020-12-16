import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Shuffle {
    public static void shuffle(int card[])
    {
        Random rand = new Random();
        for (int i = 0; i < card.length; i++)
        {
            // Random for remaining positions.
            int r = i + rand.nextInt(52 - i);

            //swapping the elements
            int temp = card[r];
            card[r] = card[i];
            card[i] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] cards = new int[52];
//        for(int i=0; i<cards.length; i++ ) {
//            cards[i]=i;
//        }
        Random random = new Random();

        List<Integer> cards = new ArrayList<>();

        IntStream.range(0,52).forEach(i -> cards.add(i));
//        System.out.println(cards);

        // Array from 0 to 51
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22,
                23, 24, 25, 26, 27, 28, 29,
                30, 31, 32, 33, 34, 35, 36,
                37, 38, 39, 40, 41, 42, 43,
                44, 45, 46, 47, 48, 49, 50,
                51};

        shuffle(a);

        // Printing all shuffled elements of cards
        for (int i = 0; i < 52; i ++)
            System.out.print(a[i]+" ");


    }
}
