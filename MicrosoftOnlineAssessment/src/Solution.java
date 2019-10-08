
public class Solution {
	
public void sortColors(int[] nums) {
	
	int i=0;
	int j=1;
	int min = nums.length-1;
	int temp = 0;
	boolean swapped = false;
	
	while(i < min) {
		if(nums[j] < nums[i])  {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			swapped = true;
			i++;
			j++;
		}
		else {
			i++;
			j++;
		}
		if(i == min && swapped == true) {
			i =0;
			j= i+1;
			min--;
		}
	}
	
	for(int k=0; k<nums.length; k++) { 
		System.out.print(nums[k]);
	}
        
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// red = 0
		// white = 1
		// blue = 2
		
		int[] test_arr = new int[] {2, 0, 2, 1, 1, 0};
	
		Solution new_arr = new Solution();
		
		new_arr.sortColors(test_arr);
		

	}

}
