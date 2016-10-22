import java.util.HashSet;
import java.util.Scanner;
public class CD
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        while(true)
        {
            int first = scan.getInt();
            int second = scan.getInt();
            int total = first + second;
            if (total == 0)
                break;
            HashSet<Integer> jack = new HashSet<Integer>();
            for(int i = 0; i < first; i++)
                jack.add(scan.getInt());
            int count = 0;
            for(int i = 0; i < second; i++)
            {
                if(jack.contains(scan.getInt()))
                    count++;
            }
            System.out.println(count);
        }
        scan.close();
    }
}