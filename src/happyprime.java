import java.util.HashSet;
import java.util.Scanner;
public class happyprime {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++){
			int print = scan.nextInt();
			int n = scan.nextInt();
			if(!isPrime(n))
				System.out.println(print + " " + n + " NO");
			else{
				int lastN = n;
				int temp = sumOfSquares(n);
				boolean happy = false;
				HashSet<Integer> current = new HashSet<Integer>();
				while(true){
					if(temp == 1){
						happy = true;
						break;
					}
					if(n == temp)
						break;
					n = temp;
					temp = sumOfSquares(temp);
					if(!current.add(temp))
						break;
				}
				if(happy)
					System.out.println(print + " " + lastN + " YES");
				else
					System.out.println(print + " " + lastN + " NO");
			}
		}
		scan.close();
	}
	
	private static int sumOfSquares(int n) {
		int sum = 0;
		int temp;
		while(n != 0){
			temp = n % 10;
			sum += (temp * temp);
			n /= 10;
		}
		return sum;
	}

	public static boolean isPrime(int n){
		if(n <= 1)
			return false;
		if(n == 2)
			return true;
		if(n % 2 == 0)
			return false;
		long sqrt = (long)Math.sqrt(n) + 1;
		for(long i = 3; i < sqrt; i+=2){
			if(n % i == 0)
				return false;
		}
		return true;
	}
}