import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
this problem does not joke
this problem does not play
do everything as fast as possible
thank you Pedro Contipelli
 */
public class integerlists
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int cases = scan.getInt();
        while (cases-- > 0)
        {
            char[] instructions = (scan.getWord().replaceAll("RR", "")).toCharArray();
            int D = getD(instructions);
            int amount = scan.getInt();
            if(amount < D)
            {
                scan.getWord();
                System.out.println("error");
            }
            else if(amount == D)
            {
                scan.getWord();
                System.out.println("[]");
            }
            else
            {
                StringTokenizer tokenizer = new StringTokenizer(scan.getWord(), ",[]");
                LinkedList<String> numbers = new LinkedList<>();
                for(int i = 0; i < amount; i++)
                    numbers.add(tokenizer.nextToken());
                boolean reverse = false;
                int size = numbers.size();
                for(char c : instructions)
                {
                    if(c == 'D')
                    {
                        if(reverse)
                           numbers.remove(size - 1);
                        else
                            numbers.remove(0);
                        size--;
                    }
                    else
                        reverse = !reverse;
                }
                if(reverse)
                {
                    Collections.reverse(numbers);
                }
                System.out.println(numbers.toString().replaceAll(" ", ""));
            }
        }
        scan.close();
    }

    public static int getD(char[] array)
    {
        int count = 0;
        for(char c : array)
            if(c == 'D')
                count++;
        return count;
    }
}
