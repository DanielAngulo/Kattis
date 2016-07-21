import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
public class zoo
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        while (true)
        {
            int amount = Integer.parseInt(scan.nextLine());
            if (amount == 0)
                break;
            TreeMap<String, Integer> map = new TreeMap<>();
            for(int i = 0; i < amount; i++)
            {
                String[] array = scan.nextLine().split(" ");
                String category = array[array.length - 1].toLowerCase();
                if(map.containsKey(category))
                    map.put(category, map.get(category)+ 1);
                else
                    map.put(category, 1);
            }
            System.out.println("List " + count + ":");
            for(Map.Entry<String,Integer> entry : map.entrySet())
            {
                System.out.println(entry.getKey() + " | " + entry.getValue());
            }
            count++;
        }
    }
}