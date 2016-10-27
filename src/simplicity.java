import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class simplicity
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        char[] array = scan.getWord().toCharArray();
        Arrays.sort(array);
        String string = new String(array);
        int simplicity = getSimplicity(string);
        if(simplicity <= 2)
            System.out.println(0);
        else
        {
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < string.length(); i++)
            {
                if(map.containsKey(string.charAt(i) + ""))
                {
                    map.put(string.charAt(i) + "", map.get(string.charAt(i) + "") + 1);
                }
                else
                    map.put(string.charAt(i) + "", 1);
            }
            int remove = 0;
            while(simplicity > 2)
            {
                int least = Integer.MAX_VALUE;
                String leastKey = "";
                for(Map.Entry<String, Integer> key : map.entrySet())
                {
                    if(key.getValue() < least)
                    {
                        least = key.getValue();
                        leastKey = key.getKey();
                    }
                }
                remove += map.get(leastKey);
                map.remove(leastKey);
                simplicity--;
            }
            System.out.println(remove);
        }
        scan.close();
    }

    public static int getSimplicity(String str)
    {
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < str.length(); i++)
            hs.add(str.charAt(i) + "");
        return hs.size();
    }
}
