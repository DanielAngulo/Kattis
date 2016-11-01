import java.util.HashMap;
import java.util.Map;

public class cups
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        HashMap<String, Integer> colors = new HashMap<String, Integer>();
        int amount = scan.getInt();
        for(int i = 0; i < amount; i++)
        {
            String color = scan.getWord();
            String radius = scan.getWord();
            try
            {
                colors.put(color, Integer.parseInt(radius));
            }
            catch(Exception e)
            {
                colors.put(radius, Integer.parseInt(color)/2);
            }
        }
        while(amount-->0)
        {
            scan.println(getLeast(colors));
        }
        scan.close();
    }

    public static String getLeast(HashMap<String, Integer> map)
    {
        String leastString = "";
        int least = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue() < least)
            {
                least = entry.getValue();
                leastString = entry.getKey();
            }
        }
        map.remove(leastString);
        return leastString;
    }
}
