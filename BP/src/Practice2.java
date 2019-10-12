
public class Practice2 {
	int k = 0;
	static int sum = 0;
	static int recur_sum=0;
	
	
	  public static int binToDec(String binary) {
	  
	  int num = Integer.parseInt(binary); // convert string to int 
	  int i = 0;
	  
	  while(num > 0) { // take last digit if(num % 10 == 1) { 
	  sum = sum + (num%10)*(int)Math.pow(2, i);
	   } 
	   num= num / 10; // increment i++; } 
	   return sum; 
	   }
	 
	
	public static int binToDec_recur(String binary, int k) {
		int num = Integer.parseInt(binary);
		
		if(num <= 0 ) {
			return recur_sum;
		}
		else {
			if(num % 10 == 1) {
				recur_sum = recur_sum + (num%10)*(int)Math.pow(2, k);				
			}
			num = num/10;
			k++;
			return binToDec_recur(String.valueOf(num),k);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "110011,1010";
		String[] values = input.split(",");
		
		String num1 = "110011"; // 110011 = 51
		String num2 = "1010"; // 1010 = 10
		String num3 = "10000"; // 16

	    System.out.println(Practice2.binToDec(num2));
	    
	    System.out.println(Practice2.binToDec_recur(num3, 0));

	}

}
