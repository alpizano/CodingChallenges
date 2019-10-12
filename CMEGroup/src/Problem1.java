import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Problem1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);	
		String line;
		String test = "";
		String test2 = "";
		
		
		while((line = in.readLine()) != null) {
			
			//System.out.println(line);
			
			test = line;
			test2 = in.readLine();
			System.out.println(test);
			System.out.println(test2);
		}
		

	}

}
