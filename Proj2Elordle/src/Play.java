import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;


public class Play {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// ask what game to play here
		System.out.println("Select a game to play:" + "\n" + "a to play Snowman" + "\n" + "b to play Wordle");
		//ask for guess
		String game = input.nextLine();
		if (game.equals("a")) {
			OnePlayerGame myGame = new Snowman(chooseRandomWord());
			playGame(myGame, input);
		}
		else {
			OnePlayerGame myGame = new Elordle(chooseRandomWord());
			playGame(myGame, input);
			
		}
		
	}
	
	public static void playGame(OnePlayerGame myGame, Scanner scnr) {
		
		/*Your playGame method in the Play class should do the following:
		Print the game state
		Loop until the game ends
		Ask the user to make a guess
		Read their guess
		If their guess is valid, play it
		Otherwise, print “Invalid guess”
		Print the game state
		 */
		System.out.println(myGame.gameState());
		//loop till game over
		while(!(myGame.isOver())) {
			System.out.println("Make a guess: ");
			//ask for guess
			String x = scnr.nextLine();
			//check if guess valid
			if (!myGame.isValid(x)) {
				System.out.println("Invalid Guess");
			}
			
			//make play with new guess
			myGame.makePlay(x);
			
			//print new game state
			System.out.println(myGame.gameState());
		}
				
	}
		
	// Code below here provided for selecting a random word.
	// You should ONLY edit the filename variable in chooseRandomWord below here!
	// ---------------------------------------------------------------------------------------
	public static String chooseRandomWord() {
		String filename = "snowwords.txt";
		Scanner file = getFileScanner(filename);
		int countLines = 0;
		while (file.hasNextLine()) {
			file.nextLine();
			countLines++; 
		}
		int randLine = (int)(Math.random() * countLines);

		file = getFileScanner(filename);
		int curLine = 0;
		while (file.hasNextLine()) {
			String word = file.nextLine();
			if(curLine == randLine) {
				return word;
			}
			curLine++; 
		}

		return "";
	}

	public static Scanner getFileScanner(String fileName) {
		try {
			FileInputStream textFileStream = new FileInputStream(fileName);
			Scanner inputFile = new Scanner(textFileStream);
			return inputFile;
		}
		catch (IOException ex) {
			System.out.println("Warning: could not open " + fileName);
			return null;
		}
	}
}
