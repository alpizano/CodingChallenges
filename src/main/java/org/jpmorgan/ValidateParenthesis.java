import java.util.Stack;

public class ValidateParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 != 0) {
            return false;
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));

                } else if (!stack.isEmpty() && ((s.charAt(i) == ')' && stack.peek() != '(') ||
                        (s.charAt(i) == '}' && stack.peek() != '{') ||
                        (s.charAt(i) == ']' && stack.peek() != '['))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "()";
        String str2 = "(]";

        ValidateParenthesis test = new ValidateParenthesis();

        System.out.println(test.isValid(str1));
        System.out.println(test.isValid(str2));
    }
}
