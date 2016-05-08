import java.util.Scanner;
public class zamka {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int L = scan.nextInt();
		int D = scan.nextInt();
		int X = scan.nextInt();
		scan.close();
		int copy = L;
		while(copy < D){
			if(sumDigits(copy) == X)
				break;
			else
				copy++;
		}
		System.out.println(copy);
		copy = D;
		while(copy <= D){
			if(sumDigits(copy) == X)
				break;
			else
				copy--;
		}
		System.out.println(copy);
	}

	private static int sumDigits(int copy) {
		int sum = 0;
		while(copy != 0){
			sum += (copy % 10);
			copy /= 10;
		}
		return sum;
	}
}
