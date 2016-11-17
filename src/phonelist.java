import java.util.Arrays;

public class phonelist
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int cases = scan.getInt();
        while(cases-- > 0)
        {
            int amount = scan.getInt();
            boolean consistent = true;
            String[] numbers = new String[amount];
            for(int i = 0; i < amount; i++)
                numbers[i] = scan.getWord();
            Arrays.sort(numbers);
            boolean loop = true;
            while(loop)
            {
                for(int i = 1; i < amount; i++)
                {
                    if(numbers[i].startsWith(numbers[i - 1]))
                    {
                        consistent = false;
                        loop = false;
                    }
                }
                loop = false;
            }
            System.out.println(consistent? "YES": "NO");
        }
    }
}