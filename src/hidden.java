import java.util.Scanner;
public class hidden
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String key = scan.next();
        char[] check = scan.next().toCharArray();
        solve:
        for(char c : check)
        {
            if(key.contains(c + ""))
            {
                if(key.charAt(0) != c)
                    break solve;
                else
                    key = key.substring(1);
            }
        }
        System.out.println(key.length() == 0? "PASS" : "FAIL");
    }
}
