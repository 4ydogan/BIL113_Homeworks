import java.util.Random;

public class Methods{ // to save methods

	public static String[][] newArrayCreate(String[][] old){ // to create a same array

		String[][] newArray = new String[old.length][old[0].length];

		for (int k = 0; k<old.length; k++) {

			for (int m = 0; m<old[0].length; m++) {
				
				newArray[k][m] = old[k][m];	
			}
		}

		return newArray;
	}

	public static int[][] createMap(String size, String difficulty){ // Locates mines randomly

		int m = Integer.parseInt(size.substring(0,size.indexOf("x"))); // to find number of rows
		int n = Integer.parseInt(size.substring(size.indexOf("x")+1)); // to find number of columns

		int count_mines;
		double percent;

		Random random = new Random();


		switch (difficulty) {
			case "E":
				percent = 0.15;
				break;
			case "M":
				percent = 0.25;
				break;
			case "H":
				percent = 0.40;
				break;
			default:
				percent = 0.0; 
		}

		count_mines = (int)(Math.ceil(m*n*percent)); // to find number of mines

		int[][] map = new int[m][n]; 
			
		while(count_mines > 0){ // to locate mines randomly

			int i = random.nextInt(m);
			int j = random.nextInt(n);
				
			if (random.nextInt(2) == 1 ) { // There is a 50% chance

				map[i][j] = 1;
				count_mines--;
			}
		}

		return map;
	}

	public static String[][] createPrintedMap(int[][] map){ // creates the map to be printed

		String[][] createdPrintedMap = new String[map.length][map[0].length];

		for (int i=0; i<createdPrintedMap.length; i++) {

			for (int j=0; j<createdPrintedMap[0].length; j++) {

				createdPrintedMap[i][j] = "o"; // Since all cells are closed at the beginning, all of them should write "o"
			}
		}

		return createdPrintedMap;
	}

	public static void printMap(String[][] printedMap){ // to print the map which be printed

		for (int i=printedMap.length-1; i>=0; i--) { // Because the index number and the rows are opposite, it decreased
			
			for (int j=0; j<printedMap[i].length; j++) {
				
				System.out.print(printedMap[i][j]);

				if (j != printedMap[i].length-1) { 
					System.out.print(" "); // prints space after every cell
				}
				else {
					System.out.println(); // when it came end of rows, it will go to the new line
				}		
			}
		}
	}

	public static String[][] losedMap(String[][] losingMap, int[][] map){ // it replace mines with "X"  

		String[][] losedPrintMap = newArrayCreate(losingMap);

		for (int i=0; i<map.length; i++) {
			
			for (int j=0; j<map[0].length; j++) {
				
				if (map[i][j] == 1) {
					
					losedPrintMap[i][j] = "X";
				}
			}
		}
		return losedPrintMap;
	}

	public static void openCell(String[][] printedMap, String[][] numberMap, int[][] map, int move_m, int move_n, String move_type){ // to open cells on the map which be printed

		if( (printedMap[move_m][move_n].equals("o") || printedMap[move_m][move_n].equals("F")) && move_type.equals("Open") && map[move_m][move_n] != 1){
			
			printedMap[move_m][move_n] = "";
			
			String result = numberMap[move_m][move_n]; // finds number of mines in neighbor cells
		
			if(Integer.parseInt(result) == 0) {
				printedMap[move_m][move_n] = "-";
			}
			else {
				printedMap[move_m][move_n] = result;
			}

			openOtherCell(printedMap, numberMap, map, move_m, move_n, move_type); // opens neighbor cells
		}
	}

	public static boolean isFinish(String[][] printedMap, String[][] numberMap, int[][] map){ // to control that game is finish

		boolean result = true;

		String[][] finishedMap = newArrayCreate(numberMap); // create temporary array 
		String[][] tempMap = newArrayCreate(printedMap); // create temporary array 

		

		for (int i = 0; i<finishedMap.length; i++) {
			
			for (int j = 0; j<finishedMap[0].length; j++) {
				
				if (finishedMap[i][j].equals("0")) {
					
					finishedMap[i][j] = "-";
				}
			}
		}

		finishedMap = losedMap(finishedMap, map); // finished the map
		tempMap = losedMap(tempMap, map); // finished the map

		for (int i=0; i<finishedMap.length; i++) { // compare two map
			
			for (int j=0; j<finishedMap[0].length; j++) {
				
				if (finishedMap[i][j].equals(tempMap[i][j]) == false) {
					
					result = false;
				}
			}
		}

		return result; // if maps are equal, returns true; if not, returns false;
	}

	public static int openOtherCell(String[][] printedMap, String[][] numberMap, int[][] map, int move_m, int move_n, String move_type){ // to open other neighbor cells
		int result = 0;
		boolean worked = false;

		if (map[move_m][move_n] != 1 ) {

			if (move_m == 0 && move_n == 0 && worked == false) { // if move is 1,1

				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells
								
					for (int i=0; i<2; i++) {

						for (int j=0; j<2; j++) {
							
							if (map[i][j] == 1 && i == 0 && j == 0) {}

							else {								
								openCell(printedMap, numberMap, map, i, j, move_type);
							}
						}
					}	
				}			
			}

			if (move_m == 0 && move_n == map[0].length-1 && worked == false) { // if move is 1,n

				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells

					for (int i=0; i<2; i++) {

						for (int j=0; j<2; j++) {
				
							if (map[i][move_n-j] == 1 && i == 0 && j == 0) {}

							else{								
								openCell(printedMap, numberMap, map, i, move_n-j, move_type);
							}
						}
					}
				}	
			}

			if (move_m == map.length-1 && move_n == 0 && worked == false) { // if move is m,1

				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells

					for (int i=0; i<2; i++) {

						for (int j=0; j<2; j++) {

							if (map[move_m-i][j] == 1 && i == 0 && j == 0) {}
							
							else {
								openCell(printedMap, numberMap, map, move_m-i, j, move_type);
							}
						}
					}	
				}
			}

			if (move_m == map.length-1 && move_n == map[0].length-1 && worked == false ) { // if move is m,n

				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells

					for (int i=0; i<2; i++) {

						for (int j=0; j<2; j++) {
							
							if (map[move_m-i][move_n-j] == 1 && i == 0 && j == 0) {}

							else {
								openCell(printedMap, numberMap, map, move_m-i, move_n-j, move_type);
							}
						}
					}	
				}
			}

			if (move_m == map.length-1 && (move_n != 0) && (move_n != map[0].length-1) && (worked == false) ) { // if move is m,random_n
				
				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells

					for (int i=0; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m-i][move_n-j] == 1 && i == 0 && j == 0) {}

							else {
								openCell(printedMap, numberMap, map, move_m-i, move_n-j, move_type);
							}
						}
					}
				}	
			}

			if (move_m == 0 && (move_n != 0) && (move_n != map[0].length-1) && (worked == false)) { // if move is 1,random_n
				
				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells

					for (int i=0; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m+i][move_n-j] == 1 && i == 0 && j == 0) {}

							else {
								openCell(printedMap, numberMap, map, move_m+i, move_n-j, move_type);
							}
						}
					}
				}	
			}

			if (move_n == 0 && (move_m != 0) && (move_m != map.length-1) && (worked == false)) { // if move is random_m,1
				
				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells

					for (int i=0; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m-j][move_n+i] == 1 && i == 0 && j == 0) {}

							else {
								openCell(printedMap, numberMap, map, move_m-j, move_n+i, move_type);
							}
						}
					}
				}	
			}

			if (move_n == map[0].length-1 && move_m != 0 && move_m != map.length-1 && (worked == false)) { // if move is random_m,n
				
				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells

					for (int i=0; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m-j][move_n-i] == 1 && i == 0 && j == 0) {}

							else {
								openCell(printedMap, numberMap, map, move_m+j, move_n-i, move_type);
							}
						}
					}
				}	
			}

			if (move_m != 0 && move_n != 0 && move_m != map.length-1 && move_n != map[0].length-1 && (worked == false)) { // if move is random_m,random_n

				worked = true;

				if(Integer.parseInt(numberMap[move_m][move_n]) == 0){ // to controls number of mines in neighbor cells

					for (int i=-1; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m-j][move_n-i] == 1 && i == 0 && j == 0) {}

							else {
								openCell(printedMap, numberMap, map, move_m-j, move_n-i, move_type);
							}
						}
					}
				}	
			}
		}

		return result;
	}

	public static String[][] createNumberMap(int[][] map){ // to create a map to save number of mines in neighbor cells
		int result = 0;
		boolean worked = false;
		int move_m;
		int move_n;

		String[][] arrayNumber = new String[map.length][map[0].length];

		for (int k=0; k<map.length; k++) {

			for (int m=0; m<map[0].length; m++) {

				move_m = k;
				move_n = m;
				worked = false;
				result = 0;

				if (move_m == 0 && move_n == 0 && worked == false) { // if move is 1,1

					worked = true;

					for (int i=0; i<2; i++) {

						for (int j=0; j<2; j++) {
							
							if (map[i][j] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}
				}			
			

				if (move_m == 0 && move_n == map[0].length-1 && worked == false) { // if move is 1,n

					worked = true;

					for (int i=0; i<2; i++) {

						for (int j=0; j<2; j++) {
							
							if (map[i][move_n-j] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}
				}

				if (move_m == map.length-1 && move_n == 0 && worked == false) { // if move is m,1

					worked = true;

					for (int i=0; i<2; i++) {

						for (int j=0; j<2; j++) {

							if (map[move_m-i][j] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}	
				}

				if (move_m == map.length-1 && move_n == map[0].length-1 && worked == false ) { // if move is m,n

					worked = true;

					for (int i=0; i<2; i++) {

						for (int j=0; j<2; j++) {
							
							if (map[move_m-i][move_n-j] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}	
				}

				if (move_m == map.length-1 && (move_n != 0) && (move_n != map[0].length-1) && (worked == false) ) { // if move is m,random_n
					
					worked = true;

					for (int i=0; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m-i][move_n-j] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}	
				}

				if (move_m == 0 && (move_n != 0) && (move_n != map[0].length-1) && (worked == false)) { // if move is 1,random_n
					
					worked = true;

					for (int i=0; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m+i][move_n-j] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}	
				}

				if (move_n == 0 && (move_m != 0) && (move_m != map.length-1) && (worked == false)) { // if move is random_m,1
					
					worked = true;

					for (int i=0; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m-j][move_n+i] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}
				}

				if (move_n == map[0].length-1 && move_m != 0 && move_m != map.length-1 && (worked == false)) { // if move is random_m,n
					
					worked = true;

					for (int i=0; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m-j][move_n-i] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}	
				}

				if (move_m != 0 && move_n != 0 && move_m != map.length-1 && move_n != map[0].length-1 && (worked == false)) { // if move is random_m,random_n
					
					for (int i=-1; i<2; i++) {

						for (int j=-1; j<2; j++) {
							
							if (map[move_m-j][move_n-i] == 1 && (i != 0 || j != 0) ) {

								result++;							
							}
						}
					}	
				}

				arrayNumber[move_m][move_n] = "" + result;
			}
		}

		return arrayNumber;
	}

	
}