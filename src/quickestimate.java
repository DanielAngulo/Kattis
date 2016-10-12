import java.util.Scanner;

public class quickestimate
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        scan.nextLine();
        while(cases-->0)
            System.out.println(scan.nextLine().length());
        scan.close();
    }
}
