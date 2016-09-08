import java.util.Scanner;
public class bishops
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt())
        {
            int n = scan.nextInt();
            if(n <= 1)
                System.out.println(n);
            else
                System.out.println((2 * n ) - 1);
        }
        scan.close();
    }
}
