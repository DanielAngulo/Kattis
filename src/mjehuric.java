import java.util.Arrays;
import java.util.Scanner;

public class mjehuric
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String check = "[1, 2, 3, 4, 5]";
        int[] set = new int[5];
        for(int i = 0; i < 5; i++)
        {
            set[i] = scan.nextInt();
        }
        while(!check.equals(Arrays.toString(set)))
        {
            for(int i = 0; i < 4; i++)
            {
                if(set[i] > set[i + 1])
                {
                    int temp = set[i];
                    set[i] = set[i + 1];
                    set[i + 1] = temp;
                    String print = Arrays.toString(set);
                    print = print.substring(1);
                    print = print.substring(0, print.length() - 1);
                    print = print.replaceAll(",", "");
                    System.out.println(print);
                }
            }
        }
        scan.close();
    }
}
