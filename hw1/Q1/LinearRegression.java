import java.util.Scanner;

public class LinearRegression{
	public static void main(String[] args){
	double x1, x2, x3, x4, y1, y2, y3, y4;

	// x1, x2, x3, x4 are the x values ​​of the points
	// y1, y2, y3, y4 are the y values ​​of the points

	System.out.println("Please enter 4 points:");
	Scanner keyboard = new Scanner(System.in);
	x1 = keyboard.nextDouble();
	y1 = keyboard.nextDouble();
	
	x2 = keyboard.nextDouble();
	y2 = keyboard.nextDouble();
	
	x3 = keyboard.nextDouble();
	y3 = keyboard.nextDouble();

	x4 = keyboard.nextDouble();
	y4 = keyboard.nextDouble();
	
	double cross_x1y1 = x1*y1;
	double cross_x2y2 = x2*y2;
	double cross_x3y3 = x3*y3;
	double cross_x4y4 = x4*y4;
	
	double total_xy = cross_x1y1 + cross_x2y2 + cross_x3y3 + cross_x4y4;
	double total_x = x1 + x2 + x3 + x4;
	double total_y = y1 + y2 + y3 + y4;

	double total_square_x = x1*x1 + x2*x2 + x3*x3 + x4*x4;

	double a, b;

	// Equation of the line is y=ax+b 

	a = (4 * total_xy - total_x * total_y)/(4 * total_square_x - total_x * total_x);
	b = (total_y - a * total_x)/4;
	System.out.println("a: " + a + " b: " + b);

	}
}