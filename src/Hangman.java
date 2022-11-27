
public class Hangman {
	String word;
	StringBuilder wrongLetters;
	StringBuilder rightLetters;
	StringBuilder currentBoard;
	boolean hasWonOrLost;
	String[] theMan;
	
	
	public Hangman() {
		String[] words = {"breath", "park", "pole", "work", "mosquito",
				"summit", "drag", "acquaintance", "motif", "bite", "fresh",
				"stun", "residence", "garage", "platform", "decide", "van",
				"laser", "trustee", "prize", "belief", "amputate", "thinker",
				};
		
		word = words[(int)(Math.random()*words.length)].toUpperCase();
		wrongLetters = new StringBuilder();
		rightLetters = new StringBuilder();
		currentBoard = new StringBuilder();
		hasWonOrLost = false;
		theMan = new String[6];
	}
	
	public void guessLetter(String letter) {
		for (int i = 0; i < 30; i++) {System.out.println("");}
//		if this guess is already in the wrong letters or the right letters
		if ((this.wrongLetters.length() > 0 
				&& letter.matches(".*[ " + this.wrongLetters + "].*")) 
				
				|| (this.rightLetters.length() > 0
				&& letter.matches(".*[ " + this.rightLetters + "].*"))){

			System.out.println("You already guessed [" + letter + "]. Try again!");
			
			System.out.println();
			updateBoard();
			return;
		}
		
		
		if (letter.matches(".*[" + this.word + "].*")) {
			this.rightLetters.append(letter);
		} else if (letter.matches(".*[A-Z].*")) {
			this.wrongLetters.append(letter);
		} else {
			System.out.println("[" + letter + "] is not a valid guess. Try again!");
		}
		
		System.out.println();
		updateBoard();
	}
	
	public void updateBoard() {
		this.currentBoard.delete(0, currentBoard.length());
		
//		check through each character in the word 
//		if the player has guessed that character,
//		then that character on the board is that letter.
//		if the player has not guessed that character,
//		then that character on the board is an underscore and space ("_ ").
		
		String wordRegEx = (this.rightLetters.length() > 0) ? ".*[" + this.rightLetters + "].*" : "_";
		boolean metWinConditions = true;
		
		for (int i = 0; i < this.word.length(); i++) {;
			if (this.word.substring(i, i+1).toUpperCase().matches(wordRegEx)) {
				this.currentBoard.append(this.word.charAt(i) + " ");
			} else {
				this.currentBoard.append("_ ");
				metWinConditions = false;
			}
			
		}
		
		
		printBoard();
		
		if (metWinConditions) {
			System.out.print("YOU WON! The word was " + this.word + "!");
			this.hasWonOrLost = true;
		}
	}
	
	public void initialBoard() {
		this.currentBoard.delete(0, currentBoard.length());
		for (int i = 0; i < this.word.length(); i++) {
			this.currentBoard.append("_ ");
		}
		
		printBoard();
	}
	
	public void printBoard() {
		System.out.println("WRONG GUESSES: " +
				this.wrongLetters.toString().toUpperCase());
		int countWrongs = wrongLetters.length();
		
		
		switch (countWrongs) {
		case 1:
			this.theMan[0] = "O";
			break;
		case 2:
			this.theMan[1] = "I";
			break;
		case 3:
			this.theMan[2] = "/";
			break;
		case 4:
			this.theMan[3] = "\\";
			break;
		case 5:
			this.theMan[4] = "/";
			break;
		case 6:
			this.theMan[5] = "\\";
			break;
		default:
			this.theMan[0] = " "; this.theMan[1] = " "; this.theMan[2] = " ";
			this.theMan[3] = " "; this.theMan[4] = " "; this.theMan[5] = " ";
		}

		System.out.println();
		System.out.println("    .....");
		System.out.println("    " + this.theMan[0] + "   :");
		System.out.println("   " + this.theMan[2] + this.theMan[1] + this.theMan[3] + "  :");
		System.out.println("   " + this.theMan[4] + " " + this.theMan[5] + "  :");
		System.out.println("      ****");
		System.out.println();
		
		/*:(
		 *    .....
		 *    O   :
		 *   /I\  :
		 *   / \  :
		 *      ****
		 */

		
		System.out.println(this.currentBoard.toString());
		System.out.println();
		if (countWrongs > 5) {
			System.out.println("YOU LOST! The word was " + this.word + ".");
			this.hasWonOrLost = true;
		}
	}
}



















