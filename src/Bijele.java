import java.util.Scanner;
public class Bijele {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] proper = {1, 1, 2, 2, 2, 8};
		int[] input = new int[6];
		for(int i = 0; i < 6; i++)
			input[i] = scan.nextInt();
		String str = "";
		for(int i = 0; i < 6; i++)
			if(input[i] == proper[i])
				str += "0 ";
			else
				str += (proper[i] - input[i]) + " ";
		System.out.println(str.trim());
	}
}
