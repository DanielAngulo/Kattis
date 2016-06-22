import java.util.Arrays;
import java.util.Scanner;
public class parking {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int[] prices = {0, scan.nextInt(), scan.nextInt(), scan.nextInt()};
		int[] starts = new int[3];
		int[] ends = new int[3];
		starts[0] = scan.nextInt();
		ends[0] = scan.nextInt();
		starts[1] = scan.nextInt();
		ends[1] = scan.nextInt();
		starts[2] = scan.nextInt();
		ends[2] = scan.nextInt();
		int[] copyStarts = Arrays.copyOf(starts, 3);
		int[] copyEnds = Arrays.copyOf(ends, 3);
		Arrays.sort(copyStarts);
		Arrays.sort(copyEnds);
		int cost = 0;
		for(int i = copyStarts[0]; i <= copyEnds[2]; i++)
		{
			int amount = 0;
			if(isInRange(i, starts[0], ends[0]))
				amount++;
			if(isInRange(i, starts[1], ends[1]))
				amount++;
			if(isInRange(i, starts[2], ends[2]))
				amount++;
			cost += (amount * prices[amount]);
		}
		System.out.println(cost);
		scan.close();
	}
	
	public static boolean isInRange(int target, int a, int b)
	{
		return target >= a && target < b;
	}
}