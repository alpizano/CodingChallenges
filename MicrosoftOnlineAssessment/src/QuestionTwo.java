import java.util.Stack;

public class QuestionTwo {

	public String removeKdigits(String num, int k) {

		Stack<String> num_stack = new Stack<>();

		if (num.length() == k) {
			return "0";
		}

		if (k == 0) {
			return num;
		}

		int i = 0;

		while (i <= num.length() - 1) {
			while (k > 0 && !num_stack.isEmpty()
					&& Integer.parseInt(Character.toString(num.charAt(i))) < Integer.parseInt((num_stack.peek()))) {
				num_stack.pop();
				k--;
			}
			num_stack.push(Character.toString(num.charAt(i)));
			i++;
		}

		while (k > 0) {
			num_stack.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();

		String sb_val = "";

		while (!num_stack.isEmpty()) {
			sb_val = num_stack.pop();
			sb.append(sb_val);
		}

		sb.reverse();
		// System.out.println(sb);

	
			while (sb.charAt(0) == '0' && sb.length() > 1) {
				sb.deleteCharAt(0);
			} 
		

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test1 = "1432219"; // k = 3, "1219"
		String test2 = "10200"; // k = 1, "200"
		String test3 = "10"; // k = 2, "0"
		String test4 = "12"; // k = 1, "1"
		String test5 = "10"; // k = 1, "0 "
		String test6 = "1234567890"; // k=9, "0"
		String test7 = "112"; // k= 1, "11"
		String test8 = "1111111"; // k= 3, "1111"

		QuestionTwo samp_obj = new QuestionTwo();

		System.out.println(samp_obj.removeKdigits(test1, 3));
		System.out.println(samp_obj.removeKdigits(test2, 1));
		System.out.println(samp_obj.removeKdigits(test3, 2));
		System.out.println(samp_obj.removeKdigits(test4, 1));
		System.out.println(samp_obj.removeKdigits(test5, 1));
		System.out.println(samp_obj.removeKdigits(test6, 9));
		System.out.println(samp_obj.removeKdigits(test7, 1));
		System.out.println(samp_obj.removeKdigits(test8, 3));

		// System.out.println(Integer.parseInt(test3)/10);
		// System.out.println(test1.substring(1, 6));

		// System.out.println(test2.charAt(2));
	}

}
