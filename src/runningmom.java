import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class runningmom
{
    static boolean found = false;
    static HashMap<String, HashSet<String>> connections = new HashMap<>();
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        connections = new HashMap<>();
        int times = scan.nextInt();
        for(int i = 0; i < times; i++)
        {
            String from = scan.next();
            String to = scan.next();
            if(connections.containsKey(from))
                connections.get(from).add(to);
            else
            {
                HashSet<String> flight = new HashSet<>();
                flight.add(to);
                connections.put(from, flight);
            }
        }
        while(scan.hasNext())
        {
            String input = scan.next();
            found = false;
            find(input, new HashSet<String>());
            System.out.println(input + " " + (found? "safe" : "trapped"));
        }
    }

    public static void find(String from, HashSet<String> path)
    {
        if(!found)
        {
            HashSet<String> get = connections.get(from);
            if(get != null)
            {
                for(String flight: get)
                {
                    if(path.contains(flight))
                    {
                        found = true;
                        return;
                    }
                }
                for(String flight : get)
                {
                    path = new HashSet<>(path);
                    path.add(flight);
                    find(flight, path);
                }
            }
        }
    }
}
