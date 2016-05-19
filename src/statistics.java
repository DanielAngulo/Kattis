import java.util.Arrays;
import java.util.Scanner;
public class statistics {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int cases = 1;
		while(scan.hasNextLine()){
			String[] parts = scan.nextLine().split(" ");
			int[] nums = new int[Integer.parseInt(parts[0])];
			for(int i = 0; i < nums.length; i++)
				nums[i] = Integer.parseInt(parts[i + 1]);
			Arrays.sort(nums);
			int min = nums[0];
			int max = nums[nums.length - 1];
			System.out.println("Case " + cases + ": " + min + " " + max + " " + (max - min));
			cases++;
		}
	}
}
