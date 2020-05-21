package Mosaics;

public class Counter {
	private static long count = 0;
	
	public static long Next()
	{
		return count++;
	}

}
