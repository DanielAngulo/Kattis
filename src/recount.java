import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class recount
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> candidates = new LinkedHashMap<>();
        while(scan.hasNext())
        {
            String input = scan.nextLine();
            if(input.equals("***"))
            {
                break;
            }
            candidates.put(input, candidates.containsKey(input)? candidates.get(input) + 1 : 1);
        }
        int max = -1;
        String name = "";
        boolean twice = false;
        for(Map.Entry<String, Integer> entry : candidates.entrySet())
        {
            int votes = entry.getValue();
            if(votes > max)
            {
                twice = false;
                max = votes;
                name = entry.getKey();
            }
            else if(votes == max)
            {
                twice = true;
            }
        }
        System.out.println(twice ? "Runoff!" : name);
    }
}
