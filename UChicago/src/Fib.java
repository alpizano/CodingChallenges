public class Fib {
    public int fibby(int n) {
        if(n <= 0 ) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fibby(n-1) + fibby(n-2);
        }
    }

    public static void main(String[] args) {
        Fib test = new Fib();

        System.out.println(test.fibby(6));
    }
}
