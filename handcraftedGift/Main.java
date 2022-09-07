package handcraftedGift;

import java.lang.Math;

/**
 * 
 * @author Owen Walton
 * @version 1 18/7/22
 * @aim Help Adam find a possible configuration of beads that satisfies all of Bob's requirements, or determine that it is impossible.
 *
 */

public class Main 
{

	public static void main(String[] args) 
	{
		int [] x = {0,1,0};
		int[] y = {1,2,2};
		int[] z = {1,1,2};
		construct(3,3,x,y, z);


	} // end main

	public static int construct(int numOfTotalBeads, int numOfRequirements, int[] startPos, int[] endPos, int[] uniqueColours)
	{
		// declare variables
		int i, j;
		int returnNum = 0;
		String str = "";
		boolean isMet = false; // stores whether requirements are met

		// loops through every possible 0 and 1 combination using binary strings adding one each time
		for (i = 0; i < (int) Math.pow(2, numOfTotalBeads ); i++)
		{
			str = Integer.toBinaryString(i);
			str = String.format("%0" + numOfTotalBeads + "d", Integer.parseInt(str));

			// converts the 0s and 1s into RED and BLUE
			str = str.replace('0', 'R');
			str = str.replace('1', 'B');


			// loops through each requirement
			for (j = 0; j < numOfRequirements; j++)
			{

				// creates a substring of the parameter for the current requirement
				String strParameters = str.substring(startPos[j], endPos[j] + 1);	



				boolean isRed = false;
				boolean isBlue = false;


				// loops through the substring each char at a time
				for (char x : strParameters.toCharArray())
				{
					if (x == 'R')
					{
						isRed = true;
					}
					else
					{
						isBlue = true;
					}

				}

				// checks if requirement is met or not and if it isn't break out the loop
				if (!((uniqueColours[j] == 1) && (isRed != true || isBlue != true) || (uniqueColours[j] == 2) && (isRed == true && isBlue == true)))
				{
					isMet = false;
					break;
				}
				else
				{
					isMet = true;
				}	
			}

			// if a correct combination is found break out of the loop to stop looking for any more
			if (isMet)
			{
				break;
			}
		}

		// if its possible print call craft, if not print "These requirements are not possible!"
		if(isMet)
		{
			craft(str);
			returnNum = 1;
		}
		else
		{
			returnNum = 0;
			System.out.println("These requirements are not possible!");	
		}
		
		return returnNum;
	} // end function



	public static void craft(String s)
	{
		// print that its possible and the combination
		System.out.println("It is possible, here is the combination:\n" + s);
	}


} // end class
