import java.util.*;

public class flagquiz
{
    static class Description
    {
        String[] description;
        int max = Integer.MIN_VALUE;

        public Description(String[] input)
        {
            this.description = input;
        }
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int amount = Integer.parseInt(scan.nextLine());
        String[] first = scan.nextLine().trim().split(", ");
        if(amount == 1)
            System.out.println(toString(first));
        else
        {
            Description[] input = new Description[amount];
            input[0] = new Description(first);
            for(int i = 1; i < amount; i++)
            {
                input[i] = new Description(scan.nextLine().trim().split(", "));
            }
            int minDist = Integer.MAX_VALUE;
            for(int i = 0; i < input.length - 1; i++)
            {
                int maxDist = Integer.MIN_VALUE;
                for(int j = 0; j < input.length; j++)
                {
                    int compare = compare(input[i].description, input[j].description);
                    if(compare > maxDist)
                    {
                        maxDist = compare;
                    }
                }
                input[i].max = maxDist;
                minDist = Math.min(minDist, maxDist);
            }
            int maxDist = Integer.MIN_VALUE;
            for(int i = 0; i < input.length - 1; i++)
            {
                int compare = compare(input[amount - 1].description, input[i].description);
                if(compare > maxDist)
                {
                    maxDist = compare;
                }
            }
            input[amount - 1].max = maxDist;
            minDist = Math.min(minDist, maxDist);
            for(int i = 0; i < amount; i++)
            {
                Description d = input[i];
                if(d.max == minDist)
                {
                    System.out.println(toString(d.description));
                }
            }
        }
    }

    public static int compare(String[] first, String[] other)
    {
        int dist = 0;
        for(int i = 0; i < first.length; i++)
        {
            if(!first[i].equals(other[i]))
            {
                dist++;
            }
        }
        return dist;
    }

    public static String toString(String[] array)
    {
        String last = "";
        for(String str : array)
            last += str + ", ";
        return last.substring(0, last.length() - 2);
    }
}
