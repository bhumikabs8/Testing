package demo;

public class TryBlockWithParameters 
{
	public static void main(String[] args) 
	{
		int dividend = 10;
		int divisor = 0;
		
		try 
		{
			int quotient = divide(dividend, divisor);
			System.out.println("Quotient: " + quotient);
		} 
		catch (ArithmeticException e) 
		{
			System.out.println("Exception caught: " + e.getMessage());
		}
	}
	
	public static int divide(int dividend, int divisor) {
		int quotient = dividend / divisor;
		return quotient;
	}
}




