import java.util.Scanner;
public class bitbybit {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt())
		{
			int instructions = scan.nextInt();
			if(instructions == 0)
				break;
			char[] bits = "????????????????????????????????".toCharArray();
			for(int loop = 0; loop < instructions; loop++)
			{
				String instruction = scan.next();
				int i = scan.nextInt();
				if(instruction.equals("SET"))
					bits[31 - i] = '1';
				else if(instruction.equals("CLEAR"))
					bits[31 - i] = '0';
				else
				{
					int j = scan.nextInt();
					char first = bits[31 - i];
					char second = bits[31 - j];
					if(instruction.equals("OR"))
						bits[31 - i] = or(first, second);
					else
						bits[31 - i] = and(first, second);
				}
			}
			System.out.println(new String(bits));
		}
		scan.close();
	}

	private static char and(char first, char second) {
		if(first == '?' || second == '?')
			return '?';
		if(first == '0' || second == '0')
			return '0';
		return '1';
	}

	private static char or(char first, char second) {
		if(first == '1' || second == '1')
			return '1';
		if(first == '?' || second == '?')
			return '?';
		return '0';
	}
}