import java.util.Scanner;

/**
 * Created by Danny on 2/19/2017.
 */
public class lekitra
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        String min = "";
        String input = scan.next();
        for(int i = 0; i < input.length() - 1; i++)
        {
            for(int x = i + 1; x < input.length(); x++)
            {
                String first = input.substring(0, i);
                String middle = input.substring(i, x);
                String last = input.substring(x);
                if(!first.isEmpty() && !middle.isEmpty() && ! last.isEmpty())
                {
                    first = new StringBuilder(first).reverse().toString();
                    middle = new StringBuilder(middle).reverse().toString();
                    last = new StringBuilder(last).reverse().toString();
                    if(!found)
                    {
                        min = first + middle + last;
                        found = true;
                    }
                    else
                    {
                        String check = first + middle + last;
                        if(check.compareTo(min) < 0)
                        {
                            min = check;
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
}
