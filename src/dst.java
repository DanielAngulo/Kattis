import java.util.Scanner;

public class dst {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++)
		{
			char direction = scan.next().charAt(0);
			int minutes = scan.nextInt();
			int currentHour = scan.nextInt();
			int currentMin = scan.nextInt();
			if(direction == 'F')
			{
				while(minutes >= 60)
				{
					currentHour++;
					minutes -= 60;
				}
				currentMin += minutes;
			}
			else
			{
				while(minutes >= 60)
				{
					currentHour--;
					minutes -= 60;
				}
				currentMin -= minutes;
				while(currentMin < 0){
					currentHour--;
					currentMin += 60;
				}
				if(currentHour < 0)
					currentHour = 24 - (Math.abs(currentHour) % 24);
			}
			while(currentMin >= 60)
			{
				currentHour++;
				currentMin -= 60;
			}
			currentHour %= 24;
			System.out.println(currentHour + " " + currentMin);
		}
		scan.close();
	}
}
