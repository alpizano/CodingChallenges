public class Test {
    public int func1(int n) {
        return n;
    }

    public static void main(String[] args) {
        int i=0;
        Test test = new Test();

        i=5;
        System.out.println(test.func1(i++));
        i=5;
        System.out.println(test.func1(++i));
        i=5;
        System.out.println(test.func1(i+1));

    }
}
