import java.util.ArrayList;
import java.util.Collections;

public class thinkingofanumber
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        while (true)
        {
            int conditions = scan.getInt();
            if (conditions == 0) break;
            ArrayList<Integer> divisible = new ArrayList<Integer>(conditions);
            int start = 0, end = 0;
            boolean startBoolean = false, endBoolean = false;
            for (int i = 0; i < conditions; i++)
            {
                String first = scan.getWord();
                scan.getWord();
                int next = scan.getInt();
                if (first.equals("less"))
                {
                    if (endBoolean)
                        end = Math.min(end, next);
                    else
                        end = next;
                    endBoolean = true;
                }
                else if (first.equals("greater"))
                {
                    next++;
                    if (startBoolean)
                        start = Math.max(start, next);
                    else
                        start = next;
                    startBoolean = true;
                }
                else
                    divisible.add(next);
            }
            Collections.sort(divisible);
            ArrayList<Integer> remove = new ArrayList<Integer>();
            for (int i = 0; i < divisible.size() - 1; i++)
            {
                for (int x = i + 1; x < divisible.size(); x++)
                {
                    if (divisible.get(x) % divisible.get(i) == 0)
                        remove.add(divisible.get(i));
                }
            }
            for (int i : remove)
                divisible.remove(new Integer(i));
            StringBuilder result = new StringBuilder("");
            if (!endBoolean)
                System.out.println("infinite");
            else if((startBoolean && endBoolean) && (start >= end))
                System.out.println("none");
            else
            {
                if (!startBoolean)
                    start = 1;
                for (int i = start; i < end; i++)
                {
                    boolean add = true;
                    check:
                    for (int x : divisible)
                    {
                        if (i % x != 0)
                        {
                            add = false;
                            break check;
                        }
                    }
                    if (add)
                        result.append(i + " ");
                }
                String print = result.toString().trim();
                System.out.println(print.length() == 0 ? "none" : print);
            }
        }
        scan.close();
    }
}
