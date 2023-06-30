package demo;

public class MultipleCatchBlock 
{
	public static void number(int n) 
	{
		try
		{
			int res=1000/n;
			System.out.println(res);
			int a1[] = {10, 20, 30};
			System.out.println(a1[n]);
		}
		catch(ArrayIndexOutOfBoundsException ae)
		{
			System.out.println("Invalid Index");
		}
		catch(Exception a)
		{
			System.out.println("Invalid number for div");
		}	
	}
	
	public static void main(String[] args) 
	{
		number(5);
		number(0);
		number(1);
	}
}
