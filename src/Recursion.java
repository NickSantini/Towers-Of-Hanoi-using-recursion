
public class Recursion {

	int diskMoves = 0;
	int[] diskNumber = new int[10000000];
	char[] From = new char[1000000]; 
	char[] To = new char [10000000]; 

	
	
	
	 public double sumseries(double n)
	 {	 
		    if(n==0)
		    {
		      return 0;
		    }
		    else
		    {
		      return (n/(3*n +1))+sumseries(n-1);
		    }
		  }
		  
	 
	 
		  public int gcd(int a, int b)
		  {
		    if(a==0 || b == 0)
		    {
		      return a+b;
		    }
		    return gcd(b,a % b);
		  }
		  
		  
		  public void TOH(int n, char a, char c, char b)
		  {
			  
		   if(n>0)
		   {
			 
		      TOH(n-1,a,b,c);
		      
		      diskNumber[diskMoves] =n;
			  From[diskMoves] = a;
			  To[diskMoves] = c; 
		      diskMoves++;
		      
		      TOH(n-1,b,c,a);
	
		    }

}
		  
}