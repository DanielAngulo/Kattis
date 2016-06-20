import java.util.Scanner;
public class howmanydigits {
	static double[] factorial = new double[1000001];
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		//stack overflow provided the proper algorithm.
		//Had previously used BigInteger, memory overflow.
		double logFacN = 0;
		factorial[0] = 1;
		factorial[1] = 1;
		for(int i = 2; i < 1000001; i++)
		{
			logFacN += Math.log10(i);
	        	factorial[i] = logFacN;
			
		}
		while(scan.hasNextInt())
		{
			int n = scan.nextInt();
			if(n <= 3)
				System.out.println(1);
			else
				System.out.println((int)(factorial[n] + 1));
		}
		scan.close();
	}
}
