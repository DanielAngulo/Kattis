import java.util.Arrays;
import java.util.Scanner;
public class parking2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0)
        {
            int stores = scan.nextInt();
            int[] locations = new int[stores];
            for(int i = 0; i < stores; i++)
                locations[i] = scan.nextInt();
            Arrays.sort(locations);
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < stores; i++)
            {
                int beforeSum = locations[i] - locations[0], afterSum = locations[stores - 1] - locations[i];
                min = Math.min((afterSum * 2) + (beforeSum * 2), min);
            }
            System.out.println(min);
        }
        scan.close();
    }
}
