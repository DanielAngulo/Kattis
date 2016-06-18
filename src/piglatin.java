import java.util.Scanner;
public class piglatin {
	static String vowels = "AEIOUYaeiouy";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine())
		{
			String[] words = scan.nextLine().split(" ");
			String result = "";
			for(String str : words)
			{
				if(vowels.contains(str.charAt(0) + ""))
					result += str + "yay ";
				else
				{
					int index = 1;
					while(!vowels.contains(str.charAt(index) + ""))
						index++;
					result += str.substring(index) + str.substring(0, index) + "ay ";
				}
			}
			System.out.println(result.trim());
		}
		scan.close();
	}
}
