import java.util.ArrayList;

public class Snowman implements OnePlayerGame {
	
	private String target;
	private int maxGuesses;
	private String tryWord;
	private ArrayList <String> incorrectGuesses;
	
	
	//overrides
	
	
	@Override
	public String gameState() {
		///Word: -----
		///Incorrect letters:
		///Guesses left: 7
		
		String x = "Word: " + tryWord + "\n" + "Incorrect letters: " + incorrectGuesses +"\n" + "Guesses left: " + (maxGuesses - incorrectGuesses.size());
		
		return x;
		
		
	}
	@Override
	public boolean isValid(String x) {
		//check if its in target string
		if (x.length() == 1) {
			if(!Character.isLowerCase(x.charAt(0))) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isOver() {
		
		if (target.equals(tryWord)) {
			System.out.println("You Won!");
			return true;
		}
		else if (incorrectGuesses.size() >= maxGuesses) {
			System.out.println("You Lost! the word was " + target);
			return true;
		}
		return false;
		
	}
	
	@Override
	public void makePlay(String x) {
		
		//if letter in target
		if (target.contains(x)) {
			//loop thru word see where letter matches
			for (int i = 0; i < target.length(); i++) {
//				char charAt = target.charAt(i);
//				String str= charAt.toString();
				String charAt = target.substring(i,i+1);
				if (x.equals(charAt)) {
					System.out.println(x);
					tryWord = tryWord.substring(0,i) + x + tryWord.substring(i+1);
					setTryWord(tryWord);
				}
			}
		}
		
		else {
			incorrectGuesses.add(x);
		}
	}
	
	
	// Constructor
	
	
	public Snowman(String target, int maxGuesses) {
		
		setTarget(target);
		setMaxGuesses(maxGuesses);
		setIncorrectGuesses(new ArrayList <String>());
		setTryWord("");
	}
	
	public Snowman() {
		this("", 7);
	}
	
	
	public Snowman(String target) {
		this(target, 7);
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
			this.maxGuesses = 7;
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
//	    else if (target.length()!=tryWord.length()) {
//	    	
//	    	this.tryWord = "";
//	    	
//			for (int i = 0; i < target.length(); i++) {
//			    this.tryWord = tryWord + ("-");
//			}
//		}
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
