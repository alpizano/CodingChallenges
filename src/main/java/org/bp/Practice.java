
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String input = "110011,1010";
		
		// 110011 = 51
		// 1010 = 10

	    String[] values = input.split(",");
	    
	    for(int i=0; i<=values.length-1; i++) {
	    	System.out.println(values[i]);
	    }
	    
	    int num1 = Integer.parseInt(values[0],2);
	    int num2 = Integer.parseInt(values[1],2);
	    
	   System.out.println(num1);
	   System.out.println(num2);

	   int sum = num1 + num2;
	   System.out.println(Integer.toBinaryString(sum));
	   
	}

}
