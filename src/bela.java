import java.util.*;

public class bela
{
    public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int hands = scan.nextInt();
		char suit = scan.next().charAt(0);
		int sum = 0;
		for(int i = 0; i < (hands * 4); i++)
		{
			String input = scan.next();
			char digit = input.charAt(0);
			boolean dominant = input.charAt(1) == suit;
			switch(digit)
			{
				case('A'): sum += 11;
					break;
				case('K'): sum += 4;
					break;
				case('Q'): sum += 3;
					break;
				case('J'): sum += (dominant? 20 : 2);
					break;
				case('T'): sum += 10;
					break;
				case('9'): sum += (dominant? 14: 0);
					break;
			}
		}
		System.out.println(sum);
		scan.close();
	}
}