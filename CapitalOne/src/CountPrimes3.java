import java.util.ArrayList;
import java.util.List;

public class CountPrimes3 {
    public int countPrimes(int n) {
        // prime number = 1, 5
    boolean isPrime = true;
    List<Integer> primeList = new ArrayList<>();

    // int n = 10;
    // 1/1
    // 2/1 , 2/2
    // 3/1 , 3/2, 3/3
    // n = 1, 2, 3, 4, 5, 6 , 7 , 8 , 9 , 10

    // 0 is not prime
    // 1 is prime
        System.out.println("3mod2" + 3%2);

        for(int i=1; i<=n; i++) {
        int factor = 1;
        //  System.out.println("n is: " + i);

        while(factor <= i) {
            if((factor != 1 && i % factor == 0) && (factor != i && i % factor == 0) ) {
                isPrime = false;
                break;
            }
            factor++;
        }
        System.out.println("n is: " + i + " and it is prime: " + isPrime);

        if(isPrime) {
            primeList.add(1);
        }

        isPrime = true;
    }

        return primeList.size();
}

    public static void main(String[] args) {
        CountPrimes3 countPrimes3 = new CountPrimes3();
        countPrimes3.countPrimes(10);

    }
}
