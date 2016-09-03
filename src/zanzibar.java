import java.util.Scanner;
import java.util.ArrayList;
public class zanzibar {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0)
        {
            boolean keep = true;
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            while(keep)
            {
                int n = scan.nextInt();
                if(n == 0)
                    keep = false;
                else
                    numbers.add(n);
            }
            int over = 0;
            for(int i = 0; i < numbers.size() - 1; i++)
            {
                if(numbers.get(i + 1) > (numbers.get(i) * 2))
                    over += numbers.get(i + 1) - numbers.get(i) * 2;
            }
            System.out.println(over);
        }
        scan.close();
    }
}
