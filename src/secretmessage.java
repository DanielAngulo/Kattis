import java.util.Scanner;
public class secretmessage
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0)
        {
            String input = scan.next();
            int length = input.length();
            int m = 0;
            getM:
            for(int i = 1; ; i++)
            {
                if(i * i >= length)
                {
                    m = i;
                    break getM;
                }
            }
            while(input.length() < m * m)
                input += "*";
            char[][] original = new char[m][m];
            for(int i = 0; i < m; i++)
                original[i] = input.substring(m * i, (m * i) + m).toCharArray();
            String print = "";
            int row = 0;
            while(row < m)
            {
                for(int x = m - 1; x >= 0; x--)
                    print += original[x][row];
                row++;
            }
            System.out.println(print.replaceAll("//*", ""));
        }
        scan.close();
    }
}
