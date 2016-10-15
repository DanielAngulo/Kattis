import java.util.Scanner;

public class bits
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-->0)
        {
            int max = 0;
            String check = scan.next();
            if(check.length() == 1)
                System.out.println(Long.toBinaryString(Long.parseLong(check)).replaceAll("0", "").length());
            else
            {
                for(int i = 1; i < check.length() + 1; i++)
                {
                    String str = Long.toBinaryString(Long.parseLong(check.substring(0, i)));
                    int count = str.replaceAll("0", "").length();
                    max = Math.max(max, count);
                }
                System.out.println(max);
            }
        }
        scan.close();
    }
}
