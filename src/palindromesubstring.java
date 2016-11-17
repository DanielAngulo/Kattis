import java.util.ArrayList;
import java.util.Collections;

public class palindromesubstring
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        while(scan.hasMoreTokens())
        {
            ArrayList<String> palindromes = new ArrayList<String>();
            String input = scan.getWord() + " ";
            int length = input.length();
            for(int i = 0; i < length - 1; i++)
            {
                char c = input.charAt(i);
                for(int x = i + 1; x < length; x++)
                {
                    if(input.charAt(x) == c)
                    {
                        String check = input.substring(i, x + 1);
                        if(isPalindrome(check) && !palindromes.contains(check))
                            palindromes.add(check);
                    }
                }
            }
            Collections.sort(palindromes);
            for(String str : palindromes)
                System.out.println(str);
            System.out.println();

        }
        scan.close();
    }

    public static boolean isPalindrome(String check)
    {
        int length = check.length() - 1;
        int bound = length/2;
        for(int i = 0; i <= bound; i++)
        {
            if(check.charAt(i) != check.charAt(length - i))
                return false;
        }
        return true;
    }
}
