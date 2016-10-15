import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class woodcutting
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-->0)
        {
            double customers = scan.nextInt();
            if(customers == 1)
            {
                int pieces = scan.nextInt();
                double average = 0;
                for(int x = 0; x < pieces; x++)
                    average += scan.nextInt();
                System.out.printf("%.10f", average);
                System.out.println();
            }
            else
            {
                ArrayList<Integer> times = new ArrayList<Integer>();
                for(int j = 0; j < customers; j++)
                {
                    int amount = scan.nextInt();
                    int sum = 0;
                    for (int x = 0; x < amount; x++)
                        sum += scan.nextInt();
                    times.add(sum);
                }
                Collections.sort(times);
                long finalSum = 0;
                int currentSum = 0;
                while(times.size() > 0)
                {
                    currentSum += times.remove(0);
                    finalSum += currentSum;
                }
                double average = (double)finalSum/customers;
                System.out.printf("%.10f", average);
                System.out.println();
            }
        }
        scan.close();
    }
}
