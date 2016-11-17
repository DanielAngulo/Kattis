import java.util.Arrays;

public class stickysituation
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int amount = scan.getInt();
        long[] data = new long[amount];
        for(int i = 0; i < amount; i++)
            data[i] = scan.getLong();
        Arrays.sort(data);
        boolean possible = false;
        loop:
        for(int i = 0; i < amount - 2; i++)
        {
            for(int x = i + 1; x < amount - 1; x++)
            {
                for(int z = x + 1; z < amount; z++)
                {
                    if(data[z] < (data[x] + data[i]))
                    {
                        possible = true;
                        break loop;
                    }
                    else
                        z = amount;
                }
            }
        }
        System.out.println(possible? "possible" : "impossible");
        scan.close();
    }

    //x + y < z
}

