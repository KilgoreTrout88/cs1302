import java.util.Scanner;

public class Hangman {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a word to guess:");
		String targetWord = console.next();
		char blank[] = new char[targetWord.length()];
		for(int i = 0; i<targetWord.length(); i++){
			blank[i] = '_';
		}
		char guess = ' ';
		String guessed = "";
		int guesses = 20;
		String temp = "";
		boolean correct = false;
		while(!correct && guesses > 0){
			for(int i = 0; i<targetWord.length(); i++){
				System.out.print(blank[i] + " ");
			}
			System.out.println("");
			System.out.println("Guessed:" + guessed);
			System.out.println("You have " + guesses + " guesses left");
			System.out.print("Enter a letter to guess:");
			guess = console.next().charAt(0);
			for(int i = 0; i<targetWord.length(); i++){
				if(guess == targetWord.charAt(i)){
					blank[i] = guess;
				}
				temp = temp + blank[i];
			}
			if(temp.equals(targetWord)){
				correct = true;
				System.out.println("You win! The word was: " + targetWord);
			}
			temp = "";
			guesses--;
			guessed = guessed + guess;
		}
	}
}
