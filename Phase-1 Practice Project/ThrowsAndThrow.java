package demo;

public class ThrowsAndThrow 
{
	public void check(int a, int b)throws Exception
	{
		throw new Exception();
	}
	public static void main(String[] args) 
	{
		ThrowsAndThrow t1 = new ThrowsAndThrow();
		try
		{
			t1.check(1, 2);
		}
		catch(Exception e)
		{
			System.out.println("Hello");
		}
		try
		{
			t1.check(1,-1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
