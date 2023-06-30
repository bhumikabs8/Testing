package demo;

public class AccessModifier 
	{
		public void add(int a, int b)
		{
			System.out.println(a+b);
		}
		
		private void subtract(int a, int b)
		{
			System.out.println(a-b);
		}

		protected void multiply(int a, int b)
		{
			System.out.println(a*b);
		}
		
		void dividied(int a, int b)
		{
			System.out.println(a/b);
		}
		
		
		public static void main(String[] args) 
		{
			AccessModifier calculator = new AccessModifier();
			
			calculator.add(10,20);
			calculator.subtract(20,10);
			calculator.multiply(20,10);
			calculator.dividied(20,10);
			

		}

	}
