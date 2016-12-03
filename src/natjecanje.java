import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class natjecanje
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int teams = scan.nextInt();
        int damaged = scan.nextInt();
        int reserved = scan.nextInt();
        int count = 0;
        ArrayList<Integer> damagedList = new ArrayList<Integer>();
        ArrayList<Integer> reservedList = new ArrayList<Integer>();
        for(int i = 0; i < damaged; i++)
            damagedList.add(scan.nextInt());
        for(int i = 0; i < reserved; i++)
            reservedList.add(scan.nextInt());
        for(int i = 0; i < damagedList.size(); i++)
        {
            if(reservedList.contains(damagedList.get(i)))
            {
                reservedList.remove(damagedList.get(i));
                damagedList.remove(i);
                i--;
            }
        }
        Collections.sort(damagedList);
        for(int i = 0; i < damagedList.size(); i++)
        {
            int n = damagedList.get(i);
            boolean m1 = reservedList.contains(new Integer(n - 1)), p1 = reservedList.contains(new Integer(n + 1));
            if(m1 && p1)
            {
                if(damagedList.contains(new Integer(n - 2)))
                {
                    reservedList.remove(new Integer(n + 1));
                    damagedList.remove(i);
                    i--;
                }
                else if(damagedList.contains(new Integer(n + 2)))
                {
                    reservedList.remove(new Integer(n - 1));
                    damagedList.remove(i);
                    i--;
                }
                else
                {
                    reservedList.remove(new Integer(n + 1));
                    damagedList.remove(i);
                    i--;
                }
            }
            else if(p1)
            {
                reservedList.remove(new Integer(n + 1));
                damagedList.remove(i);
                i--;
            }
            else if(m1)
            {
                reservedList.remove(new Integer(n + 1));
                damagedList.remove(i);
                i--;
            }
            else
                count++;
        }
        System.out.println(count);
    }
}