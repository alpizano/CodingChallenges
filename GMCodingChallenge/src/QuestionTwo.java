import java.util.Arrays;

public class QuestionTwo {

	public static void main(String[] args) {
		// Input String
		String line = "1,4,7,8;2,3,5,6";
		// List<Integer> doublet = new ArrayList<>();

		// Split input into 2 different Strings on(;) delimiter
		String[] values = line.split(";");

		// Set each String[] array element to new String
		String list1 = values[0];
		String list2 = values[1];

		// Split each new String on comma (,) delimiter
		String[] list1_arr = list1.split(",");
		String[] list2_arr = list2.split(",");

		// Initialize a new array with size as sum of first 2 strings
		int[] merge_arr = new int[list1_arr.length + list2_arr.length];

		// Iterate and determine lowest value in each array
		int i = 0;
		int l1 = 0;
		int l2 = 0;
		StringBuilder sb = new StringBuilder();

		while (i <= merge_arr.length - 1) {
			if (l2 <= list2_arr.length - 1 && l1 <= list1_arr.length - 1) {
				if (Integer.parseInt(list1_arr[l1]) < Integer.parseInt(list2_arr[l2])) {
					merge_arr[i] = Integer.parseInt(list1_arr[l1]);
					sb.append("(");
					if (Integer.parseInt(list1_arr[l1]) < Integer.parseInt(list2_arr[l2])) {
						sb.append(Integer.parseInt(list1_arr[l1]));
						sb.append(",");
						sb.append(Integer.parseInt(list2_arr[l2]));
					} else {
						sb.append(Integer.parseInt(list2_arr[l2]));
						sb.append(",");
						sb.append(Integer.parseInt(list1_arr[l1]));
					}
					sb.append(")");
					l1++;
				} else if (Integer.parseInt(list2_arr[l2]) < Integer.parseInt(list1_arr[l1])) {
					merge_arr[i] = Integer.parseInt(list2_arr[l2]);
					sb.append("(");

					if (Integer.parseInt(list1_arr[l1]) < Integer.parseInt(list2_arr[l2])) {
						sb.append(Integer.parseInt(list1_arr[l1]));
						sb.append(",");
						sb.append(Integer.parseInt(list2_arr[l2]));
					} else {
						sb.append(Integer.parseInt(list2_arr[l2]));
						sb.append(",");
						sb.append(Integer.parseInt(list1_arr[l1]));
					}
					sb.append(")");
					l2++;
				}
			} else {
				break;
			}
			i++;
		}

		// Whatever array has elements left over, copy them into merge_arr
		while (l1 <= list1_arr.length - 1 || l2 <= list2_arr.length - 1) {
			if (l1 <= list1_arr.length) {
				merge_arr[i] = Integer.parseInt(list1_arr[l1]);
				l1++;
			} else {
				merge_arr[i] = Integer.parseInt(list2_arr[l2]);
				l2++;
			}
			i++;
		}

		StringBuilder sb2 = new StringBuilder();

		for (int z = 0; z <= merge_arr.length - 1; z++) {
			sb2.append(merge_arr[z]);
			sb2.append(",");
		}
		sb2.deleteCharAt(sb2.length() - 1);

		// String output = String.join(",",Arrays.toString(merge_arr));

		System.out.println(sb2);
		System.out.println(sb);
	}
}
