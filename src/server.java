import java.util.Scanner;
public class server {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int amount = scan.nextInt();
		int limit = scan.nextInt();
		int sum = 0;
		int count = 0;
		for(int i = 0; i < amount; i++){
			int n = scan.nextInt();
			if(sum + n > limit)
				break;
			else
				sum += n;
			count++;
		}
		System.out.println(count);
	}
}
