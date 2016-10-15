import java.util.Scanner;

public class soylent
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-->0)
        {
            int input = scan.nextInt();
            System.out.println(input % 400 == 0? (input/400): (input/400) + 1);
        }
        scan.close();
    }
}
