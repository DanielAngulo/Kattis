import java.util.HashMap;
import java.util.Map;

public class touchscreenkeyboard
{
    static String[] keyboard = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int cases  = scan.getInt();
        while(cases-->0)
        {
            String check = scan.getWord();
            int others = scan.getInt();
            HashMap<String, Integer> distances = new HashMap<String, Integer>();
            for(int i = 0; i < others; i++)
            {
                String input = scan.getWord();
                distances.put(input, getDistance(check, input));
            }
            while(distances.size() != 0)
            {
                System.out.println(getSmallest(distances));
            }
        }
        scan.close();
    }

    public static int getDistance(String one, String two)
    {
        int count = 0;
        for(int i = 0; i < one.length(); i++)
        {
            int[] first = new int[2];
            int[] second = new int[2];
            for(int x = 0; x < 3; x++)
                if(keyboard[x].contains(one.charAt(i) + ""))
                    first[0] = x;
            first[1] = keyboard[first[0]].indexOf(one.charAt(i) + "");
            for(int x = 0; x < 3; x++)
                if(keyboard[x].contains(two.charAt(i) + ""))
                    second[0] = x;
            second[1] = keyboard[second[0]].indexOf(two.charAt(i) + "");
            count += (Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]));
        }
        return count;
    }

    public static String getSmallest(HashMap<String, Integer> map)
    {
        String smallestString = "";
        int smallest = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == smallest)
            {
                if(smallestString.compareTo(entry.getKey()) > 0)
                    smallestString = entry.getKey();
            }
            else if(entry.getValue() < smallest)
            {
                smallestString = entry.getKey();
                smallest = entry.getValue();
            }
        }
        map.remove(smallestString);
        return smallestString + " " + smallest;
    }
}
