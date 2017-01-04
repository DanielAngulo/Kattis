import java.util.HashSet;
import java.util.Scanner;

public class imagedecoding
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        while(true)
        {
            if(lines == 0)  break;
            HashSet<Integer> lengths = new HashSet<Integer>();
            for(int i = 0; i < lines; i++)
            {
                String[] input = scan.nextLine().split(" ");
                char first = input[0].charAt(0);
                StringBuilder print = new StringBuilder("");
                for(int x = 1; x < input.length; x++)
                {
                    int n = Integer.parseInt(input[x]);
                    for(int y = 0; y < n; y++)
                        print.append(first);
                    if(first == '.')
                        first = '#';
                    else
                        first = '.';
                }
                lengths.add(("" + print).length());
                System.out.println(print);
            }
            if(lengths.size() != 1)
                System.out.println("Error decoding image");
            lines = Integer.parseInt(scan.nextLine());
            if(lines != 0)
                System.out.println();
        }
        scan.close();
    }
}
