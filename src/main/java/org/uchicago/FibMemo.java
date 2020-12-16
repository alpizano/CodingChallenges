import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibMemo {
    public int fibonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return fibonacci(n, map);
    }
        public int fibonacci(int n, Map<Integer, Integer> memo) {
            if(n <= 0 ) {
                return 0;
            }
            else if (n == 1) {
                return 1;
            }
            else if(!memo.containsKey(n)){
               int result = fibonacci(n-1, memo) + fibonacci(n-2, memo);
               memo.put(n, result);
            }
            return memo.get(n);
        }

        public static void main(String[] args) {
            FibMemo test = new FibMemo();

            System.out.println(test.fibonacci(6));
        }
    }


