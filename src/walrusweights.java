import java.util.*;
public class walrusweights
{
    static int[] set;
    static ArrayList<Integer> closest = new ArrayList<Integer>();
    static int size = 0;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        size = amount + 1;
        set = new int[1 + amount];
        for(int i = 1; i < amount + 1; i++)
            set[i] = scan.nextInt();
        Arrays.sort(set);
        getClosest(0, 0, false, 100001);
        Collections.sort(closest);
        while(closest.get(0) == 0)
            closest.remove(0);
        int nearest = closest.get(0);
        for(int i : closest)
        {
            if(Math.abs(1000 - i) <= Math.abs(1000 - nearest))
                nearest = i;
        }
        System.out.println(nearest);
    }

    public static void getClosest(int index, int sum, boolean use, int nearest)
    {
        closest.add(sum);
        closest.add(nearest);
        if(index == size)
            return;
        if(use)
            sum += set[index];
        index++;
        if(sum != 0)
        {
            if(Math.abs(1000 - sum) < Math.abs(1000 - nearest))
                nearest = sum;
            else
                return;
        }
        getClosest(index, sum, true, nearest);
        getClosest(index, sum, false, nearest);
    }
}
