import java.util.ArrayList;
import java.util.Scanner;

public class mirror
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int x = 0; x < cases; x++)
        {
            ArrayList<StringBuilder> output = new ArrayList<StringBuilder>();
            int rows = scan.nextInt();
            scan.nextInt();
            scan.nextLine();
            for(int i = 0; i < rows; i++)
                output.add(0, new StringBuilder(scan.nextLine()).reverse());
            System.out.println("Test " + (x + 1));
            for(StringBuilder str : output)
                System.out.println(str);
        }
        scan.close();
    }
}
