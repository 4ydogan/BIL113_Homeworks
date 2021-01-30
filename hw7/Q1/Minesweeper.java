import java.util.Scanner;
import java.util.Random;

public class Minesweeper{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[][] map;
		String[][] printedMap;
		String[][] numberMap;

		int move_m, move_n;
		String size, difficultiy, move, move_type;

		System.out.println("\n\t:::::::::WELCOME:::::::::\n");

		System.out.print("Please enter the sizes of the board (mxn):");
		size = scan.nextLine(); // to find size

		System.out.print("Please select the difficulty (E, M, H):");
		difficultiy = scan.nextLine(); // to find difficulty

		System.out.println("\n\t:::::::::::::::::::::::::\n");

		map = Methods.createMap(size, difficultiy);  // to create a map contain index of mines 
		printedMap = Methods.createPrintedMap(map);  // to create a map which be printed
		numberMap = Methods.createNumberMap(map); 	 // to create a map contain number of mines

		for (int i=0; i<map.length; i++) {

			for (int j=0; j<map[0].length; j++) {
				
				System.out.print(map[i][j]);

				if (j != map[i].length-1) { 
					System.out.print(" "); // prints space after every cell
				}
				else {
					System.out.println(); // when it came end of rows, it will go to the new line
				}
			}
		}


		while(true){

			Methods.printMap(printedMap); // prints map
			System.out.print("\nPlease make a move:");
			move = scan.nextLine(); // to find movement

			if (move.indexOf(" ",move.indexOf(",")) == -1) {
				move_m = Integer.parseInt(move.substring(0,move.indexOf(","))) - 1; // to find row
				move_n = Integer.parseInt(move.substring(move.indexOf(",")+1)) - 1; // to find column

				move_type = "Open"; // to find move type
			}
			else {
				
				if (move.substring(move.indexOf(" ")+1).equals("F")) { 
					move_m = Integer.parseInt(move.substring(0,move.indexOf(","))) - 1; // to find row
					move_n = Integer.parseInt(move.substring(move.indexOf(",")+1, move.indexOf(" "))) - 1; // to find column

					move_type = "Flag"; // to find move type
				}

				else if(move.substring(move.indexOf(" ")+1).equals("U")) {
					move_m = Integer.parseInt(move.substring(0,move.indexOf(","))) - 1; // to find row
					move_n = Integer.parseInt(move.substring(move.indexOf(",")+1, move.indexOf(" "))) - 1; // to find column

					move_type = "Unflag"; // to find move type
				}
				else { // default

					move_m = 0;
					move_n = 0;
					move_type = "";
				}
			}

			if (move_type.equals("Flag") && printedMap[move_m][move_n].equals("o")) { // if move type is "Flag"
				printedMap[move_m][move_n] = "F";
			}

			else if (move_type.equals("Unflag") && printedMap[move_m][move_n].equals("F")) { // if move type is "Unflag"
				printedMap[move_m][move_n] = "o";
			}

			if(map[move_m][move_n] == 0 && move_type.equals("Open") ) { // if there isn't a mine
				
				if (move_type.equals("Open") && printedMap[move_m][move_n].equals("o")) { // if move type is "Open"
					Methods.openCell(printedMap, numberMap, map, move_m, move_n, move_type);
				}

				else if (move_type.equals("Open") && printedMap[move_m][move_n].equals("F")) { // if wants to open a flagged cell
					System.out.println("Flagged cells cannot be opened.");
				}

				else if (move_type.equals("Open") && printedMap[move_m][move_n].equals("o") == false) { // if wants to open a open cell
					System.out.println("Cell is already open.");
				}
			}

			else if ( map[move_m][move_n] == 1 && !(printedMap[move_m][move_n].equals("F"))) { // if there is a mine

				printedMap = Methods.losedMap(printedMap,map); // to expose the mines
				Methods.printMap(printedMap);
				System.out.println("You lost, better luck next time.");
				break;
			}

			if (Methods.isFinish(printedMap, numberMap, map) == true) { // if all cell are openned, game finishes and gamer is won
				printedMap = Methods.losedMap(printedMap,map);
				Methods.printMap(printedMap);
				System.out.println("Congratulations, you won.");
				break;
			}
		}
	}
}