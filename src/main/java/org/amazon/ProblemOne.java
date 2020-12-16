public class ProblemOne {
	
	public static int[] reverseArray(int arr[]) {
		int i;
		int temp;
		int originalLen = arr.length;
		int len = originalLen;
		
		for(i=0; i < originalLen/2; i++) {
			temp = arr[len-1];
			arr[len-1] = arr[i];
			arr[i] = temp;
			
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] test_arr = new int[] {2,8,4,6};
		
		ProblemOne.reverseArray(test_arr);
		
		for(Integer i: test_arr) {
			System.out.println(i);
		}
		
		
		}

	}


