import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class textureanalysis
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = 1;
        while(true)
        {
            String string = scan.next();
            if(string.equals("END"))
                break;
            char[] pixels = string.toCharArray();
            if(!string.contains("."))
                System.out.println(cases + " EVEN");
            else
            {
                ArrayList<Integer> distances = new ArrayList<Integer>();
                distances.add(0);
                for(int i = 1; i < pixels.length; i++)
                {
                    if(pixels[i] == '*')
                        distances.add(i);
                }
                boolean even = true;
                int distance = distances.get(1) - distances.get(0);
                for(int i = 0; i < distances.size() - 1; i++)
                {
                    if(distances.get(i + 1) - distances.get(i) != distance)
                    {
                        even = false;
                        i = distances.size();
                    }
                }
                if(even)
                    System.out.println(cases + " EVEN");
                else
                    System.out.println(cases + " NOT EVEN");
            }
            cases++;
        }
        scan.close();
    }
}
