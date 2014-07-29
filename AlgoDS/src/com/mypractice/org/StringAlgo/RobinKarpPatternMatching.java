package com.mypractice.org.StringAlgo;

import java.math.BigInteger;
import java.util.Random;

public class RobinKarpPatternMatching {

	/**
	 * @param args
	 */
	private long qPrime;
	private int radix;
	private int patternLength;
	private long leadingDigit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new RobinKarpPatternMatching().robinKarpPatternToHash("abbcbaagh","");

	}

	private void robinKarpPatternToHash(String patt,String text)
	{
		try
		{
			radix=1;
			qPrime = longPrime();
			System.out.println("LongPrime-->"+qPrime);
			System.out.println("OffsetOrRaddix -->"+offsetOrRadix(patt,qPrime));
			System.out.println("Hash-->"+patternToHash(patt,qPrime)); 
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	private long offsetOrRadix(String pattern,long qPrime)
	{
		radix=256;
		leadingDigit=1;
		for(int i=0;i<pattern.length();i++)
		{
			leadingDigit = (radix*leadingDigit)%qPrime;
		}
		return leadingDigit;
	}
	
	private long patternToHash(String pattern,long qPrime)
	{
		long h=0;
		for(int i=0;i<pattern.length();i++)
		{
			h=(radix*h+pattern.charAt(i))%qPrime; 
		}
		return h;
	}
	
	
	private long longPrime()
	{
		BigInteger b = BigInteger.probablePrime(31,new Random());
		return b.longValue();
	}
	
	
}
