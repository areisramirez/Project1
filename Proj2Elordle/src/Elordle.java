import java.util.ArrayList;

public class Elordle implements OnePlayerGame {
	
	private String target;
	private int maxGuesses;
	private String tryWord;
	private ArrayList <String> incorrectGuesses;

	@Override
	public String gameState() {
		///Word: -----
		///Incorrect letters:
		///Guesses left: 7
		
		String x = "Word: " + tryWord  + "\n" + "Guesses left: " + (maxGuesses);
		
		return x;
		
		
	}
	@Override
	public boolean isValid(String x) {
		//check if its in target string
		
		if (x.length() == target.length()) {
			for (int i = 0; i < target.length(); i++) {
				if(!Character.isLowerCase(x.charAt(i))) {
					return false;
				}
			}
				return true;
		}
			return false;
	}
	
	@Override
	public boolean isOver() {
		
		if (target.equals(tryWord.toLowerCase())) {
			System.out.println("You Won!" + "\n" + "In only " + maxGuesses + " guesses");
			return true;
		}
		else if (maxGuesses <= 0) {
			System.out.println("You Lost :( The word was " + target);
			return true;
		}
		return false;
		
	}
	
	@Override
	public void makePlay(String x) {
		
		for (int i = 0; i < x.length(); i++) {
			String letter = x.substring(i,i+1);
			if (target.contains(letter)) {
				int ind = target.indexOf(letter);
				if (i == ind) {
					tryWord = tryWord.substring(0, i) + letter.toUpperCase() + tryWord.substring(i+1);
					setTryWord(tryWord);
				}
				else {
					tryWord = tryWord.substring(0, i) + letter.toLowerCase() + tryWord.substring(i+1);
					setTryWord(tryWord);
				}
				
			}
			
		}
		maxGuesses = maxGuesses - 1;
		
	}
	
	// Constructor
	
	
		public Elordle(String target, int maxGuesses) {
			
			setTarget(target);
			setMaxGuesses(maxGuesses);
			setIncorrectGuesses(new ArrayList <String>());
			setTryWord("");
		}
		
		public Elordle() {
			this("", 5);
		}
		
		
		public Elordle(String target) {
			this(target, 5);
		}
		
		//Setters
		public void setTarget(String target) {
			
			if (target == null) {
			this.target = "";
			}
			
			if (target.contains(" ")) {
				int space = target.indexOf(" ");
				this.target = target.substring(0,space);
			}
			
			this.target = target;
		}
		
		public void setMaxGuesses(int maxGuesses) {
			
			if (maxGuesses <= 0 || maxGuesses > 26) {
				this.maxGuesses = 5;
			}
			else {
				this.maxGuesses = maxGuesses;
			}
		}
		
		public void setTryWord(String tryWord) { 
			
			if (this.tryWord == null) {
				
				this.tryWord = "";
				
				for (int i = 0; i < target.length(); i++) {
				    this.tryWord = this.tryWord + ("-");
				     
				}
			
			}
//		    
		}
		
		public void setIncorrectGuesses (ArrayList <String> incorrectGuesses){
			
			this.incorrectGuesses = incorrectGuesses;
			
			if (incorrectGuesses == null) {
				this.incorrectGuesses = new ArrayList<>();
			}	
		}
		
		///Getters
		
		public String getTarget(String target) {
			return target;
		}
		
		public String getTryWord(String tryWord) {
			return tryWord;
		}
		
		public int getMaxGuesses(int maxGuesses) {
			return maxGuesses;
		}
		
		public ArrayList<String> getIncorrectGuesses (ArrayList <String> incorrectGuesses) {
			return incorrectGuesses;
		}
	
}
