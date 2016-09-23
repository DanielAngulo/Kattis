import java.util.Scanner;
public class quickbrownfox
{
    public static void main(String[] args)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        scan.nextLine();
        while(cases-->0)
        {
            boolean[] letters = new boolean[26];
            String input = scan.nextLine().toLowerCase();
            for(int i = 0; i < input.length(); i++)
            {
                try
                {
                    letters[alphabet.indexOf(input.charAt(i))] = true;
                }
                catch(Exception e){;}
            }
            String missing = "";
            for(int i = 0; i < 26; i++)
            {
                if(!letters[i])
                    missing += alphabet.charAt(i);
            }
            System.out.println(missing.length() == 0? "pangram": "missing " + missing);
        }
        scan.close();
    }
}
