import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class primalrepresentation
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            int n = scan.nextInt();
            LinkedHashMap<Integer, Integer> primeFactors = new LinkedHashMap<>();
            if(n < 0)
            {
                primeFactors.put(-1, 1);
                n *= -1;
            }
            while(n % 2 == 0)
            {
                primeFactors.put(2, primeFactors.containsKey(2) ? primeFactors.get(2) + 1 : 1);
                n /= 2;
            }
            for (int i = 3; i <= Math.sqrt(n); i+= 2)
            {
                while (n%i == 0)
                {
                    primeFactors.put(i, primeFactors.containsKey(i) ? primeFactors.get(i) + 1 : 1);
                    n /= i;
                }
            }
            if(n > 2)
                primeFactors.put(n, 1);
            String print = "";
            for(Map.Entry<Integer, Integer> entry : primeFactors.entrySet())
            {
                if(entry.getValue() == 1)
                    print += entry.getKey() + " ";
                else
                    print += entry.getKey() + "^" + entry.getValue() + " ";
            }
            System.out.println(print.trim());
        }
        scan.close();
    }
}
