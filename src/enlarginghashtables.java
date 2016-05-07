import java.util.Scanner;
public class enlarginghashtables {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			long n = scan.nextLong();
			if(n == 0)
				break;
			else{
				long other = 2 *n;
				other++;
				boolean prime = isPrime(n);
				long before = other; 
				while(before >0)
					if(isPrime(before))
						break;
					else
						before++;
				if(prime)
					System.out.println(before);
				else
					System.out.println(before + " (" + n + " is not prime)");
			}
		}
	}
	
	public static boolean isPrime(long n){
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
