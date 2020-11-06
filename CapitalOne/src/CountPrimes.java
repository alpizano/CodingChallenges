import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
    public int countPrimes(int n) {
        List<Integer> primeNumList = new ArrayList<>();
        boolean prime = true;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                if(j != 1 && i != j && i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if(prime && !primeNumList.contains(i)) {
                primeNumList.add(i);
            }
            prime = true;
        }

        System.out.println(primeNumList);

        return primeNumList.size();
    }

    public static void main(String[] args) {
        CountPrimes test = new CountPrimes();

        test.countPrimes(499979);
    }

}
