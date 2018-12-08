package jonathan_schwartz_code_repository;


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class HashTester{
	
	//generates hash code using Horner's method and coefficient a
	public static int hashDat(String in) {
		int hash = 0;
		int a=17;
		for(int i=0;i<in.length();i++)
		  hash = a*hash + in.charAt(i);
		
		return hash;
		
	}
	
	//generates hash code with bit shifting
	public static int cyclicShift(String in) {
		int hash = 0;
		for (int i=0; i<in.length(); i++) {
			hash = (hash << 7) | (hash >>> 25); //if first int increases/decreases, the second must do the opposite
			hash += (int) in.charAt(i);
		}
		
		return hash;
	}
	
	//original Java hashing algorithm for strings
	public static int oldHash(String in) {
		int hash = 0;
		int skip = Math.max(1,  in.length()/8);
		for (int i=0; i<in.length(); i += skip) {
			hash = (hash * 37) + in.charAt(i);
		}		
		return hash;
	}

	public static void main(String[] args) {
		
		Map m1 = new HashMap();
		ArrayList<String> words = new ArrayList<String>();
		int word_count = 0;
		
		File file = new File("words.txt");
		try {
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				
				//words are read with the scanner into the words list
				String line = scanner.nextLine(); 
				words.add(line);
			
				}
			scanner.close();
			
			System.out.println("Word logging complete! Number of words: " + words.size());
			word_count = words.size();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Attempt to input file failed");
		}
		
		//this loop generates hash codes for objects and adds the pairs to the map m1
		for (int i=0; i<words.size(); i++) {
                int val = cyclicShift(words.get(i));
                m1.put(val, words.get(i));
		}
		
		Map<String, String> sorted = new TreeMap<String, String>(m1);
		int uniques = 0;
		//loop counts how many unique keys are being used
        for (Object key : sorted.keySet()) {
        	uniques++;
        }
        //prints total number of keys used, then reports the difference between total words
        //and keys used as the number of collisions
        System.out.println("Unique Keys: " + uniques + "\tCollisions: " +  (word_count - uniques));
	}
}
