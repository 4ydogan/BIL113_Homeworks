public class JumpIt{

	public static void main(String[] args) {
		int[] array = {2, 5, 3, 1, 3, 2, 2, 1, 1};
		int[] path = getPath(array);

		// to print output

		System.out.println("array[] = {2, 5, 3, 1, 3, 2, 2, 1, 1}");
		System.out.print("Solution:" + path.length + " (");

		for (int i=0; i<path.length; i++) {

			System.out.print(path[i]);

			if (i<path.length-1) {

				System.out.print("->");
			}
		}

		System.out.println(")");

	}

	public static int[] getPath(int[] array){

		int[] path = new int[array.length];
		int index = 0;
		int i=0;
		int number_of_zero = 0;

		while (index<array.length-1) {

			int max = 0;
			int temp = 0;
		
			path[i] = index; // jumps there
			i++;

			for (int j=1; j<=array[index]; j++ ) { 
				
				if (j+index>=array.length){ // if index exceeds or equals length of array 

					temp = array.length-1-index;	
				}

				else if (max < array[j+index]+j+index) { // to find max
					max = array[j+index]+j+index;
					temp = j; // to find count of step
				}
			}

			index = temp + index;

			if (index == array.length-1) { // if index equals length of array 
				path[i] = array.length-1;
			}
		}

		for (int j=0; j<path.length; j++) { // to clean zeros end of array

			if ( path[j] == 0 ) {

				number_of_zero++;
			}
		}

		int[] final_path = new int[path.length-number_of_zero+1];
		int x = 0;

		do{
			final_path[x] = path[x];  // to create final array
			x++;
		}
		while(x<path.length && path[x] != 0);

		return final_path; // returns path
	}
}