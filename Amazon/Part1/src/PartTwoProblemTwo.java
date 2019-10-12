import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class PartTwoProblemTwo {
	
//	public HashMap<String, List<String>> favoriteVideoGenre(int numUsers, HashMap<String, List<String>> userBooksListenedTo, int numGenres, HashMap<String, List<String>> bookGenres) {
//		
//		for(String s: userBooksListenedTo.keySet()) {
//			
//		}
//		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numUsers =3;
		
		Map<String, List<String>> userBooksListenedTo  = new HashMap<String, List<String>>();
		
		int numGenres= 3;
		
		HashMap<String, List<String>> bookGenres = new HashMap<>();
		HashMap<String, List<String>> returned_map = new HashMap<>();
		
		List<String> fred_books_list = new ArrayList<>();
		List<String> jenie_books_list = new ArrayList<>();
		List<String> rone_books_list = new ArrayList<>();
		
		fred_books_list.add("mass");
		fred_books_list.add("world");
		fred_books_list.add("stress");
		
		jenie_books_list.add("happy");
		jenie_books_list.add("pride");
		
	
		rone_books_list.add("alexender");
		
		
		List<String> horror_genres_list = new ArrayList<>();
		List<String> comedy_genres_list = new ArrayList<>();
		List<String> romance_genres_list = new ArrayList<>();
		
		horror_genres_list.add("mass");
		horror_genres_list.add("stress");
		
		comedy_genres_list.add("happy");
		
		romance_genres_list.add("world");
		romance_genres_list.add("alexender");
		romance_genres_list.add("pride");

		
		userBooksListenedTo.put("Fred",fred_books_list);
		userBooksListenedTo.put("Jenie",jenie_books_list);
		userBooksListenedTo.put("Rone",rone_books_list);
		
		bookGenres.put("Horror", horror_genres_list);
		bookGenres.put("Comedy", comedy_genres_list);
		bookGenres.put("Romance", romance_genres_list);
		
		PartTwoProblemTwo test = new PartTwoProblemTwo();
		
//		returned_map = test.favoriteVideoGenre(numUsers, userBooksListenedTo, numGenres, bookGenres);
		
		//int k=0;
		for(Map.Entry<String,List<String>> entry: userBooksListenedTo.entrySet()) {
			//System.out.println(userBooksListenedTo.get(s));
			for(String l: userBooksListenedTo.get(entry)) {
			if(entry.equals("Fred")) {
					System.out.println(l);

				}
				
			//System.out.println(k);
				//k++;
			}	
		}
		
		for(String s:userBooksListenedTo.keySet()) {
			if(userBooksListenedTo.get(s).equals("mass")) {
				System.out.println(s);
			}
		}
		
		//userBooksListenedTo.contain
		

	}

}
