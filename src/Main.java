import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	private static final int ROCK = 1;
	
	private static final int PAPER = 2;
	
	private static final int SCISSAOR = 3;
	
	public static void main(String[] args) {
		
		int opponent = createOpponent();
		
		int input = 0;
		
		try {
			input = chooseNumber();
		} catch (InputMismatchException e) {
			System.err.println("Invalid input");
			return;
		}
		
		judge(input, opponent);
		
	}
	
	private static int createOpponent() {
		return (int)(Math.random()*3)+1;
	}
	
	private static int chooseNumber() throws InputMismatchException {
		System.out.println("1: Rock ");
		System.out.println("2: Paper ");
		System.out.println("3: Scissor ");

		System.out.print("Choose number: " );

		Scanner in = new Scanner(System.in);
		
		int input = in.nextInt();
	
		if (input != ROCK && input != PAPER && input != SCISSAOR) {
			throw new InputMismatchException();
		}
		
		return input;
	}
	
	private static void judge(int userInput, int opponent) {
		
		if (userInput == opponent) {
			System.out.println("Draw");
		} else if ((userInput == ROCK && opponent == SCISSAOR) ||
				(userInput == SCISSAOR && opponent == PAPER) || 
				(userInput == PAPER && opponent == ROCK)) {
			System.out.println("You Win");
		} else {
			System.out.println("You Lose");
		}

	}
}
