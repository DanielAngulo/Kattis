import java.util.Scanner;

public class trik {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		char[] instructions = scan.next().toCharArray();
		int current = 1;
		for(char c : instructions)
		{
			if(c == 'A')
			{
				if(current == 1)
					current = 2;
				else if(current == 2)
					current = 1;
			}
			else if(c == 'B')
			{
				if(current == 2)
					current = 3;
				else if(current == 3)
					current = 2;
			}
			else
			{
				if(current == 1)
					current = 3;
				else if(current == 3)
					current = 1;
			}
		}
		System.out.println(current);
		scan.close();
	}
}