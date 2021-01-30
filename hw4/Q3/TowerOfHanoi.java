import java.util.Scanner;

public class TowerOfHanoi{
	public static int stringToInt(String x){
		if (x.equals(" ")) {
			return 4;
		}
		if (x.equals("1")) {
			return 1;
		}
		if (x.equals("2")) {
			return 2;
		}
		if (x.equals("3")) {
			return 3;
		}
		return 0;
	}

	public static String decrease(String y){
		return y.substring(1) + " ";
	}

	public static String add(String m, String n){
		return m + n;
	}

	public static String increase(String z){
		return z.substring(0,3);
	}

	public static void main(String[] args){
		String tower_A = "123", tower_B = "   ", tower_C = "   ";
		String peg_A, peg_B, peg_C, deleted, result_A="", result_B="", result_C="";
		int int_A, int_B, int_C, legal = 0, illegal = 0, x=0, index_A, index_B, index_C;
		String move;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Game of Hanoi!..");
		System.out.println();

		System.out.println(tower_A.substring(0,1) + "\t\t" + tower_B.substring(0,1) + "\t\t" + tower_C.substring(0,1));
		System.out.println(tower_A.substring(1,2) + "\t\t" + tower_B.substring(1,2) + "\t\t" + tower_C.substring(1,2));
		System.out.println(tower_A.substring(2,3) + "\t\t" + tower_B.substring(2,3) + "\t\t" + tower_C.substring(2,3));
		System.out.println();

		while(tower_C.equals("123") != true){
			
			System.out.print("Please make a move:");
			move = keyboard.nextLine();

			peg_A = tower_A.substring(0,1);
			peg_B = tower_B.substring(0,1);
			peg_C = tower_C.substring(0,1);

			int_A = stringToInt(peg_A);
			int_B = stringToInt(peg_B);
			int_C = stringToInt(peg_C);

			if (move.equals("A-B")) {
				if (int_A > int_B && int_A != 4) {
					System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
					illegal++;
				}
				else if (int_A == 4) {
					System.out.println("Illegal move: peg is empty.");
					illegal++;
				}
				else{
					deleted = tower_A.substring(0,1);
					tower_A = decrease(tower_A);
					tower_B = add(deleted, tower_B);
					tower_B = increase(tower_B);
					legal++;
				}
			}

			if (move.equals("A-C")) {
				if (int_A > int_C && int_A != 4) {
					System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
					illegal++;
				}
				else if (int_A == 4) {
					System.out.println("Illegal move: peg is empty.");
					illegal++;
				}
				else{
					deleted = tower_A.substring(0,1);
					tower_A = decrease(tower_A);
					tower_C = add(deleted, tower_C);
					tower_C = increase(tower_C);
					legal++;
				}
			}

			if (move.equals("B-A")) {
				if (int_B > int_A && int_B != 4) {
					System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
					illegal++;
				}
				else if (int_B == 4) {
					System.out.println("Illegal move: peg is empty.");
					illegal++;
				}
				else{
					deleted = tower_B.substring(0,1);
					tower_B = decrease(tower_B);
					tower_A = add(deleted, tower_A);
					tower_A = increase(tower_A);
					legal++;
				}
			}

			if (move.equals("B-C")) {
				if (int_B > int_C && int_B != 4) {
					System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
					illegal++;
				}
				else if (int_B == 4) {
					System.out.println("Illegal move: peg is empty.");
					illegal++;
				}
				else{
					deleted = tower_B.substring(0,1);
					tower_B = decrease(tower_B);
					tower_C = add(deleted, tower_C);
					tower_C = increase(tower_C);
					legal++;
				}
			}

			if (move.equals("C-A")) {
				if (int_C > int_A && int_C != 4) {
					System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
					illegal++;
				}
				else if (int_C == 4) {
					System.out.println("Illegal move: peg is empty.");
					illegal++;
				}
				else{
					deleted = tower_C.substring(0,1);
					tower_C = decrease(tower_C);
					tower_A = add(deleted, tower_A);
					tower_A = increase(tower_A);
					legal++;
				}
			}

			if (move.equals("C-B")) {
				if (int_C > int_B && int_C != 4) {
					System.out.println("Illegal move : bigger disk cannot be placed on top of smaller disk");
					illegal++;
				}
				else if (int_C == 4) {
					System.out.println("Illegal move: peg is empty.");
					illegal++;
				}
				else{
					deleted = tower_C.substring(0,1);
					tower_C = decrease(tower_C);
					tower_B = add(deleted, tower_B);
					tower_B = increase(tower_B);
					legal++;
				}
			}

			if (move.equals("A-A")) {
				if (int_A == 4) {
					System.out.println("Illegal move: peg is empty.");	
					illegal++;				
				}
				else{
					legal++;
				}	
			}

			if (move.equals("B-B")) {
				if (int_B == 4) {
					System.out.println("Illegal move: peg is empty.");	
					illegal++;				
				}
				else{
					legal++;
				}				
			}

			if (move.equals("C-C")) {
				if (int_C == 4) {
					System.out.println("Illegal move: peg is empty.");	
					illegal++;				
				}
				else{
					legal++;
				}				
			}

			result_A = tower_A;
			index_A = result_A.indexOf(" ");
			while(index_A < 3 && index_A != -1){
				result_A = " " + result_A;
				index_A++;
			}
			result_A = result_A.substring(0,3);
			
			result_B = tower_B;
			index_B = result_B.indexOf(" ");
			while(index_B < 3 && index_B != -1){
				result_B = " " + result_B;
				index_B++;
			}
			result_B = result_B.substring(0,3);
			
			result_C = tower_C;
			index_C = result_C.indexOf(" ");
			while(index_C < 3 && index_C != -1){
				result_C = " " + result_C;
				index_C++;
			}
			result_C = result_C.substring(0,3);
			
			System.out.println();
			System.out.println(result_A.substring(0,1) + "\t\t" + result_B.substring(0,1) + "\t\t" + result_C.substring(0,1));
			System.out.println(result_A.substring(1,2) + "\t\t" + result_B.substring(1,2) + "\t\t" + result_C.substring(1,2));
			System.out.println(result_A.substring(2,3) + "\t\t" + result_B.substring(2,3) + "\t\t" + result_C.substring(2,3));
			System.out.println();
		}

		System.out.println("Congratulations you won!..");
		System.out.println("You made " + legal +" legal moves to win.");
		System.out.println("Also you tried to make " + illegal + " illegal moves.");
	}
}