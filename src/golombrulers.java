import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class golombrulers
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            LinkedHashMap<Integer, Sum> sums = new LinkedHashMap();
            String[] input = scan.nextLine().split(" ");
            int[] values = new int[input.length];
            for(int i = 0; i < input.length; i++)
                values[i] = Integer.parseInt(input[i]);
            Arrays.sort(values);
            int max = values[values.length - 1];
            String missing = "";
            int missingCount = 0;
            boolean ruler = true;
            loop:
            for(int i = 1; i < values.length; i++)
            {
                for(int x = 0; x < i; x++)
                {
                    int check = values[i] - values[x];
                    Sum checkSum = new Sum(values[i], values[x]);
                    if(sums.containsKey(check))
                    {
                        if(!sums.get(check).equals(checkSum))
                        {
                            ruler = false; break loop;
                        }
                    }
                    else
                        sums.put(check, new Sum(values[i], values[x]));
                }
            }
            if(ruler)
            {
                int start = values[0];
                for(int i = start; i <= max; i++)
                {
                    if(!sums.containsKey(i))
                    {
                        missing += i + " ";
                    }
                }
                while(missing.startsWith("0"))
                    missing = missing.substring(1);
                missing = missing.trim();
                System.out.println(missing.length() == 0? "perfect" : "missing " + missing);
            }
            else
                System.out.println("not a ruler");
        }
        scan.close();
    }
}

class Sum
{
    int x, y;

    public Sum(int x, int y)
    {
        this.x = Math.min(x, y);
        this.y = Math.max(x, y);
    }

    public boolean equals(Sum s)
    {
        return this.x == s.x && this.y == s.y;
    }

    public String toString()
    {
        return x + " " + y;
    }
}
