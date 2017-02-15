import java.util.Arrays;
import java.util.Scanner;

public class mastermind
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        StringBuilder code = new StringBuilder(scan.next()), guess = new StringBuilder(scan.next());
        int s = 0, r = 0;
        for(int i = 0; i < length; i++)
        {
            if(code.charAt(i) == guess.charAt(i))
            {
                r++;
                code.deleteCharAt(i);
                guess.deleteCharAt(i);
                i--;
                length--;
            }
        }
        for(int i = 0; i < length; i++)
        {
            int guessIndex = guess.indexOf(code.charAt(i) + "");
            if(guessIndex != -1)
            {
                s++;
                code.deleteCharAt(i);
                i--;
                guess.deleteCharAt(guessIndex);
                length--;
            }
        }
        System.out.println(r + " " + s);
    }
}
