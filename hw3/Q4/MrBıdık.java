import java.util.Scanner;

public class MrBıdık{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the geometric shape which you wish to compute its volume:");
		String geometricShape = keyboard.nextLine(); // takes a type of geometric shape from user

		if (geometricShape.equals("cube") == true) // if the shape is cube, calculates volume of cube.
		{
			System.out.print("Please enter the length of the cube:");
			double lengthOfCube = keyboard.nextDouble();
			double volumeOfCube = Math.pow(lengthOfCube, 3);
			System.out.println("Volume of the cube is " + volumeOfCube);
		}

		if (geometricShape.equals("cylinder") == true) // if the shape is cylinder, calculates volume of cylinder.
		{
			System.out.print("Please enter the height and radius of the cylinder:");
			double heightOfCylinder = keyboard.nextDouble();
			double radiusOfCylinder = keyboard.nextDouble();
			double volumeOfCylinder = Math.PI * Math.pow(radiusOfCylinder, 2) * heightOfCylinder;
			System.out.println("Volume of the cylinder is " + volumeOfCylinder);
		}

		if (geometricShape.equals("sphere") == true) // if the shape is sphere, calculates volume of sphere.
		{
			System.out.print("Please enter the radius of the sphere:");
			double radiusOfSphere = keyboard.nextDouble();
			double volumeOfSphere = Math.PI * Math.pow(radiusOfSphere,3) * 4 / 3;
			System.out.println("Volume of the sphere is " + volumeOfSphere);
		}	

		if (geometricShape.equals("rectangular prism") == true) // if the shape is rectangular prism, calculates volume of rectangular prism.
		{
			System.out.print("Please enter the length, height, and width of the rectangular prism:");
			double lengthOfRectangularPrism = keyboard.nextDouble();
			double heightOfRectangularPrism = keyboard.nextDouble();
			double widthOfRectangularPrism = keyboard.nextDouble();
			double volumeOfRectangularPrism = lengthOfRectangularPrism * heightOfRectangularPrism * widthOfRectangularPrism;
			System.out.println("Volume of the rectangular prism is " + volumeOfRectangularPrism);
		}	
	}
}