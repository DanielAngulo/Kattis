import java.util.Scanner;
public class friday
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases--> 0)
        {
            int amountOfDays = scan.nextInt();
            int months = scan.nextInt();
            int[] days = new int[months];
            for(int i = 0; i < months; i++)
            {
                days[i] = scan.nextInt();
            }
            //Sunday = 0, Monday = 1, Tuesday = 2, Wednesday = 3, Thursday = 4, Friday = 5, Saturday = 6
            int current = 0;
            int count = 0;
            for(int i = 0; i < months; i++)
            {
                for(int x = 0; x < days[i]; x++)
                {
                    if(x == 12 && current == 5)
                        count++;
                    current = (current + 1) % 7;
                }
            }
            System.out.println(count);
        }
        scan.close();
    }
}
