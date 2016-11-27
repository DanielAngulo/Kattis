import java.util.ArrayList;
import java.util.HashSet;
public class wheresmyinternet
{
    static ArrayList<House> cables = new ArrayList<House>();
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int houses = scan.getInt();
        int connections = scan.getInt();
        cables = new ArrayList<House>(houses);
        cables.add(0, null);
        for(int i = 1; i < houses + 1; i++)
            cables.add(i, new House(i, 0));
        while(connections-- > 0)
        {
            int currentHouse = scan.getInt();
            int connection = scan.getInt();
            cables.get(currentHouse).connections.add(connection);
            cables.get(connection).connections.add(currentHouse);
        }
        for(int n : cables.get(1).connections)
            connect(n);
        for(int i = 2; i < houses + 1; i++)
        {
            if(cables.get(i).connections.contains(1))
                connect(i);
        }
        boolean print = false;
        for(int i = 2; i < cables.size(); i++)
        {
            House h = cables.get(i);
            if (!h.connected)
            {
                print = true;
                System.out.println(h.n);
            }
        }
        if(!print)
            System.out.println("Connected");
        scan.close();
    }

    public static void connect(int index)
    {
        cables.get(index).connected = true;
        for(int n : cables.get(index).connections)
            if(!cables.get(n).connected)
                connect(n);
    }
}

class House
{
    int n;
    HashSet<Integer> connections = new HashSet<Integer>();
    boolean connected = false;

    public House(int n, int connected)
    {
        this.n = n;
        if(connected != 0)
            connections.add(connected);
        if(n == 1 || connected == 1)
            this.connected = true;
    }

    public String toString()
    {
        return n + " " + connections + " " + connected;
    }
}
