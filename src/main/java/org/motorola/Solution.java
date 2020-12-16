import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public boolean isAnagram(String str1, String str2) {
		
		if(str1.length()-1 != str2.length()-1) {
			return false;
		}
		
		List<String> str_list1 = new ArrayList<>();
		List<String> str_list2 = new ArrayList<>();
		
		for(int i =0; i<=str1.length()-1; i++) {
			str_list1.add(String.valueOf(str1.charAt(i)).toLowerCase());
			str_list2.add(String.valueOf(str2.charAt(i)).toLowerCase());
		}
	
		
		Collections.sort(str_list1);
		Collections.sort(str_list2);
		
		System.out.println(str_list1);
		System.out.println(str_list2);
		

		System.out.println(str_list1.toString().equals(str_list2.toString()));
		
		return str_list1.toString().equals(str_list2.toString());
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "Listen";
		String str2 = "Silent";
		
		Solution test = new Solution();
		
		test.isAnagram(str1, str2);
		
		
		
		
	}

}
