import java.util.*;

public class brexit
{
    static HashMap<Integer, HashSet<Integer>> countries;
    static HashMap<Integer, Integer> halves;
    static int myCountry, amount;
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        amount = scan.getInt() + 1;
        int partnerships = scan.getInt();
        myCountry = scan.getInt();
        int first = scan.getInt();
        if(first == myCountry)
        {
            System.out.println("leave");
            System.exit(0);
        }
        countries = new HashMap<Integer, HashSet<Integer>>(amount);
        halves = new HashMap<Integer, Integer>(amount);
        for(int i = 0; i < partnerships; i++)
        {
            int country = scan.getInt(), partner = scan.getInt();
            if(countries.containsKey(country))
            {
                countries.get(country).add(partner);
            }
            else
            {
                HashSet<Integer> temp = new HashSet<Integer>();
                temp.add(partner);
                countries.put(country, temp);
            }
            if(countries.containsKey(partner))
            {
                countries.get(partner).add(country);
            }
            else
            {
                HashSet<Integer> temp = new HashSet<Integer>();
                temp.add(country);
                countries.put(partner, temp);
            }
        }
        for(int i = 1; i < amount; i++)
            halves.put(i, countries.get(i).size()/2);
        remove(first);
        System.out.println("stay");
    }

    public static void remove(int n)
    {
        if(n == myCountry)
        {
            System.out.println("leave");
            System.exit(0);
        }
        HashSet<Integer> linked = countries.remove(n);
        countries.remove(n);
        if(linked == null)
            return;
        for(int i : linked)
        {
            try
            {
                countries.get(i).remove(n);
                if(countries.get(i).size() <= halves.get(i))
                {
                    remove(i);
                }
            }
            catch (Exception e){continue;}
        }
    }
}