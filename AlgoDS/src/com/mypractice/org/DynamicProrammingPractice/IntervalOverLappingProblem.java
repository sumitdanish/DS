package com.mypractice.org.DynamicProrammingPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class IntervalOverLappingProblem {

	public static void main(String[] args)
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			ArrayList<Inteval> intervalList = new ArrayList<Inteval>();
			System.out.println("Enter Interval Pair..");
			for(int i=0;i<4;i++)
			{
				String[] s = sc.next().split(",");
				intervalList.add(new Inteval(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
			}
			Collections.sort(intervalList,new StartPointShorting());
			for(Inteval i : intervalList)
			{
				System.out.println("{"+i.startTime+","+i.endTime+"}");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	
	
}
class StartPointShorting implements Comparator<Inteval>
{

	@Override
	public int compare(Inteval o1, Inteval o2) {
		// TODO Auto-generated method stub
		return o1.startTime-o2.startTime;
	}
	
}
class Inteval
{
	int startTime;
	int endTime;
	public Inteval(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
}
