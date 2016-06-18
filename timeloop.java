import java.util.Scanner;
public class timeloop {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int amount = scan.nextInt() + 1;
		for(int i = 1; i < amount; i++)
		{
			System.out.println(i + " Abracadabra");
		}
		scan.close();
	}
}
