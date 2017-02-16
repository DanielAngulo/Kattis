import java.util.Scanner;

public class commercials
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt(), cost = scan.nextInt();
        int[] students = new int[amount];
        for(int i = 0; i < amount; i++)
        {
            students[i] = scan.nextInt() - cost;
        }
        int max = 0;
        int current = 0;
        for(int i : students)
        {
            if(current + i < 0)
            {
                current = 0;
            }
            else
            {
                current += i;
            }
            max = Math.max(max, current);
        }
        System.out.println(max);
    }
}
