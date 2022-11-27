import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {System.out.println("");}
		System.out.println("Welcome to HANGMAN");
		System.out.println();
		System.out.println("    .....");
		System.out.println("    O   :");
		System.out.println("   /I\\  :");
		System.out.println("   / \\  :");
		System.out.println("      ****");
		System.out.println();
		System.out.println("PRESS [S] TO START");
		
		Scanner scanner = new Scanner(System.in);
		while (!scanner.next().toLowerCase().equals("s")) {
			System.out.println("invalid");
		}
		
		startHere();
	}
	
	public static void startHere() {
		Hangman game1 = new Hangman();
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < 30; i++) {System.out.println("");}
		
		game1.initialBoard();
		while (!game1.hasWonOrLost) {
			System.out.print("YOUR GUESS: ");
			game1.guessLetter(scanner.next().toUpperCase());
		}
		
		
	}
	


}
