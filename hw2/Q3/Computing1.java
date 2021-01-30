import java.util.Scanner;

public class Computing1{
	public static void main(String[] args){
		double x1, x2, y1, y2, z1, z2; //x, y, and z values ​​of points
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter two points:");
		
		x1 = keyboard.nextDouble(); // x value of the first point
		y1 = keyboard.nextDouble(); // y value of the first point
		z1 = keyboard.nextDouble(); // z value of the first point

		x2 = keyboard.nextDouble(); // x value of the first point
		y2 = keyboard.nextDouble(); // y value of the first point
		z2 = keyboard.nextDouble(); // z value of the first point

		double manhattanDistance = Math.abs(x1-x2) + Math.abs(y1-y2) + Math.abs(z1-z2);
		double euclideanDistance = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2) + Math.pow(z1-z2,2));
		double cosineDistance = 1 - (x1*x2 + y1*y2 + z1*z2)/Math.sqrt((x1*x1 + y1*y1 + z1*z1)*(x2*x2 + y2*y2 + z2*z2));

		System.out.println("Manhattan distance is equal to:" + manhattanDistance);
		System.out.println("Euclidean distance is equal to:" + euclideanDistance);
		System.out.println("Cosine distance is equal to:" + cosineDistance);
	}
}
