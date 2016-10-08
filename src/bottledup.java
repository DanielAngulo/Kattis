import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class bottledup
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int b1 = scan.nextInt();
        int b2 = scan.nextInt();
        int count = 0;
        LinkedHashMap<Integer, Integer> solutions = new LinkedHashMap<>();
        boolean solved = false;
        while(true)
        {
            if(b1 * count > total)
                break;
            int remaining = total - b1 * count;
            if(remaining % b2 == 0)
            {
                solutions.put(count, remaining/b2);
                solved = true;
            }
            count++;
        }
        if(!solved)
            System.out.println("Impossible");
        else
        {
            int least = Integer.MAX_VALUE;
            String leastString = "";
            for(Map.Entry<Integer, Integer> entry : solutions.entrySet())
            {
                int key = entry.getKey();
                int value = entry.getValue();
                if(key + value < least)
                {
                    least =  key + value;
                    leastString = key + " " + value;
                }
            }
            System.out.println(leastString);
        }
        scan.close();
    }
}
