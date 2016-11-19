import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class closestsums
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int currentCase = 1;
        while (scan.hasNext())
        {
            System.out.println("Case " + currentCase + ": ");
            int input = scan.nextInt();
            int[] numbers = new int[input];
            for(int i = 0; i < input; i++)
                numbers[i] = scan.nextInt();
            ArrayList<Integer> closest = new ArrayList<Integer>();
            Arrays.sort(numbers);
            for(int x = 0; x < input - 1; x++)
            {
                for(int z = x + 1; z < input; z++ )
                    closest.add(numbers[z] + numbers[x]);
            }
            Collections.sort(closest);
            int check = scan.nextInt();
            while(check-- > 0)
            {
                int find = scan.nextInt();
                int near = closest.get(0);
                for(int i = 1; i < closest.size(); i++)
                {
                    if(Math.abs(find - closest.get(i)) <= Math.abs(find - near))
                        near = closest.get(i);
                    else
                        break;
                }
                System.out.println("Closest sum to " + find + " is " + near + ".");
            }
            currentCase++;
        }
    }
}
