import java.util.*;

public class torn2pieces
{
    static String end;
    static HashMap<String, HashSet<String>> connections = new HashMap<>();
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        connections = new HashMap<>();
        int times = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < times; i++)
        {
            String[] input = scan.nextLine().split(" ");
            String current = input[0];
            HashSet<String> connect = new HashSet<String>();
            if(connections.containsKey(current))
                connect = connections.get(current);
            for(int y = 1; y < input.length; y++)
            {
                String check = input[y];
                if(!connect.contains(check))    connect.add(check);
                if(!connections.containsKey(check))
                {
                    HashSet<String> temp = new HashSet<>();
                    temp.add(current);
                    connections.put(check, temp);
                }
                else
                {
                    connections.get(check).add(current);
                }
            }
            connections.put(current, connect);
        }
        String start = scan.next();
        end = scan.next();
        HashSet<String> used = new HashSet<>();
        used.add(start);
        find(start, start, used);
        System.out.println("no route found");
        scan.close();
    }

    public static void find(String current, String path, HashSet<String> used)
    {
        HashSet<String> connected = connections.get(current);
        if(connected == null)
            return;
        for(String str : connected)
        {
            if(str.equals(end))
            {
                System.out.println(path + " " + end);
                System.exit(0);
            }
            else
            {
                used = new HashSet<>(used);
                if(used.add(str))
                {
                    find(str, path + " " + str, used);
                }
            }
        }
    }
}
