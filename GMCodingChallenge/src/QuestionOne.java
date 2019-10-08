
public class QuestionOne {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	int n = 9 ;
    	int grams_mined = 0 ;
    	int robots = 0;
    	int robots_mining = 0;
    	int robots_cloning = 1;
    	int days =1;
    	int total_days =0;
    	
        while(grams_mined < n) {
        	robots = robots + 1;
        	
        	if(days > 1) {
        	robots_cloning =  robots_cloning*2;
        	 
        	}
        	
        	//if(n - total_days == 1) {
        		//robots_mining++;
        	//}
        	
        	if(robots_cloning >= n) {
        		robots_mining = robots_cloning;
        		grams_mined = robots_mining;    		
        	}
        	System.out.println("cloned robots: " + robots_cloning + " on day: " + days + " with: " + robots_mining + " robots mining" + " and " +  grams_mined + " grams mined");

    		days++;
    		total_days = days - 1;  		
    	}
        
    	System.out.println();
    	System.out.println("Miminum number of days taken to mine " + n + " grams was " + total_days + " days");

	}

}


