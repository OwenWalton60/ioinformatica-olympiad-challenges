package jellyFlavours;

import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		int[] x = {5, 7, 9, 2}; 
		int[] y = {4,6,8,1};
		System.out.println(find_maximum_unique(4, 5, x,y));

	} // end main
	
	
	public static int find_maximum_unique(int store_A_money, int store_B_money, int[] store_A_cost, int[] store_B_cost)
	{
		int numOfJelly = 0;
		int i;
		
		Arrays.sort(store_A_cost);
		Arrays.sort(store_B_cost);
		
		for (i = 0; i < store_A_cost.length; i++)
		{
			if (store_A_cost[i] <= store_A_money)
			{
				store_A_money -= store_A_cost[i];
				numOfJelly += 1;
			}
			else
			{
				break;
			}
				
		}
		
		for (i = 0; i < store_B_cost.length; i++)
		{
			if (store_B_cost[i] <= store_B_money)
			{
				store_B_money -= store_B_cost[i];
				numOfJelly += 1;
			}
			else
			{
				break;
			}
				
		}

		return numOfJelly;
		
	} // end function

} // end class
