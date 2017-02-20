import java.util.Scanner;

public class artichoke
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt(), a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt(), d = scan.nextInt(), n = scan.nextInt();
        double max = p * (Math.sin(a * 1 + b) + Math.cos(c * 1 + d) + 2);
        double lowest = 0;
        for(int i = 2; i <= n; i++)
        {
            double current = p * (Math.sin(a * i + b) + Math.cos(c * i + d) + 2);
            if(current > max)
                max = current;
            else
            {
                double drop = max - current;
                if(lowest == 0)
                {
                    lowest = drop;
                }
                else
                    lowest = Math.max(lowest, drop);
            }
        }
        System.out.println(lowest);
        scan.close();
    }
}
