import java.util.HashMap;
import java.util.Map;

public class judging
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int amount = scan.getInt();
        HashMap<String, Integer> times = new HashMap<String, Integer>();
        for(int i = 0; i < amount; i++)
        {
            String input = scan.getWord();
            if(!times.containsKey(input))
            {
                times.put(input, 1);
            }
            else
            {
                times.put(input, times.get(input) + 1);
            }
        }
        for(int i = 0; i < amount; i++)
        {
            String input = scan.getWord();
            try
            {
                times.put(input, times.get(input) - 1);
            }
            catch (Exception e){}
        }
        int total = 0;
        for(Map.Entry<String, Integer> entry : times.entrySet())
        {
            total += Math.max(0, entry.getValue());
        }
        System.out.println(amount - total);
        scan.close();
    }
}
