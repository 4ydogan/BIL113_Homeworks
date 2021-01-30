import java.util.Scanner;

public class Rephrasing2{
 	public static void main (String[] args){
 		String orijinalSentence;
 		Scanner keyboard = new Scanner(System.in);
 		System.out.print("Please enter the sentence:");
 		orijinalSentence = keyboard.nextLine();
 		
 		int indexIf = orijinalSentence.indexOf(" if "); //Finds the index of 'if'.
 		int length = orijinalSentence.length(); //Finds the length of the sentence.
 		
 		String first = orijinalSentence.substring(0, indexIf); //Determines the part of the sentence before the 'if'.
 		String second = orijinalSentence.substring(indexIf + 1, length - 1); //Determines the part of the sentence after the 'if'.

 		first = (first.substring(0,1).toLowerCase() + first.substring(1)); // to make the first letter of the sentence smaller
 		second = (second.substring(0,1).toUpperCase() + second.substring(1)); // to capitalize the first letter of the new sentence

 		System.out.println("Repharased sentence: " + second + ", " + first + ".");
 		
 	}
}