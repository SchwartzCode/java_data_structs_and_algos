package comp20010_tutorial_1;

//package snippets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @version 1.0 September 2017
 * 
 * @author Aonghus Lawlor
 * @student Jonathan Schwartz
 */
public class ScoreBoard {
	private int maxEntries;
	private int numEntries; // number of actual entries
	private GameEntry[] board; // array of game entries (name and scores)

	public ScoreBoard(int capacity) {
		maxEntries = capacity;
		numEntries = 0;
		board = new GameEntry[capacity];
		
		for (int i=0; i<capacity; i++) {
			board[i] = new GameEntry("", 0);
		}
	}

	/** Attempts to add a new score to the collection (if it is high enough). */
	public void add(GameEntry e) {
		if (numEntries < maxEntries)
		{
			board[numEntries] = e;
			numEntries++;
		}
		else if (numEntries == maxEntries && e.getScore() > board[numEntries - 1].getScore()) {
			board[numEntries-1] = e;
			
		}
		
		//starts at new entry and moves it up hiscore list to where it belongs
		for (int i=(numEntries-1); i>0; i--) {
			if (board[i].getScore() > board[i-1].getScore()) {
				GameEntry temp = board[i-1];
				board[i-1] = board[i];
				board[i] = temp;
			}
			else {break;} //breaks out of loop once added score is where it belongs
		}
	}

	/** Attempts to remove an existing score from the collection */
	public GameEntry remove(int i) throws IndexOutOfBoundsException {
		GameEntry output = board[0];
		if (i <= numEntries)
		{
			output = board[i-1];
			
			for (int a = i; a<numEntries; a++) {
				board[i-1] = board[i];
			}
			
			board[i+1]= new GameEntry("", -1);
			numEntries--;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
		
		return output;
	}

	public String toString() {
		String out = "";
		
		for (int i=0; i<numEntries; i++) {
			out += board[i].toString() + "\n";
		}

		return out;
	}

	public static void main(String[] args) {

		ScoreBoard pizza = new ScoreBoard(100); //set max scoreboard size here

		File file = new File("scores.txt");
		try {
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				Scanner lineReader = new Scanner(line).useDelimiter(",\\s?+"); // comma followed by any number of spaces
				String name = lineReader.next();
				int score_input = lineReader.nextInt();
				
				GameEntry temp_GE = new GameEntry(name, score_input);
				pizza.add(temp_GE);
				
				

				lineReader.close();
			}
			scanner.close();
			
			System.out.println("\nTHE SCOREBOARD:\n");
			System.out.println(pizza);
			

		} catch (FileNotFoundException e) {
			// TODO: 
		}
	}

}
