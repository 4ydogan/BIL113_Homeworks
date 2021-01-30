import java.util.*;

public class GamblersRuin
{
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Initial money:");
		int initialMoney = keyboard.nextInt();

		System.out.print("Goal:");
		int goal = keyboard.nextInt();

		System.out.print("Probability of winning in a round:");
		double probability = keyboard.nextDouble();

		System.out.print("Number of times the game will be simulated:");
		int numberOfTimes = keyboard.nextInt();

		if (goal > initialMoney)
		{
			int money = initialMoney; // to save value of initialMoney 
			int win = 0;			  // if we win the raund, values of win increases by one
			int lose = 0;			  // if we lose the raund, values of lose increases by one
			int raund = 0;			  // value of raund increases by one in each raund

			while(goal>money && money>0 && raund != numberOfTimes)
			{
				money--;
				Random random = new Random();
				float randomProbiblity = random.nextFloat();

				if ( randomProbiblity < probability) 
					money += 2;
						

				while (money == goal)
				{
					win++;
					raund++;
					money = initialMoney;
				}

				while( money == 0)
				{
					lose++;
					raund++;
					money = initialMoney;
				}
			}
			System.out.println("Win:" + win);
			System.out.println("Lose:" + lose);
		}
	}
}