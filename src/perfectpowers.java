import java.util.*;

public class perfectpowers
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            long number = scan.nextInt();
            if (number == 0)
                break;
            if(number == 1)
                System.out.println(1);
            else
            {
                boolean negative = false;
                if(number < 0)
                {
                    negative = true;
                    number = -number;
                }
                ArrayList<Long> primeFactors = getPrimeFactors(number);
                Collections.sort(primeFactors);
                long gcd = primeFactors.remove(0);
                for(long i : primeFactors)
                {
                    if(gcd == 1)
                        break;
                    gcd = gcd(gcd, i);
                }
                if(!negative)
                    System.out.println(gcd);
                else
                {
                    while(gcd % 2 == 0)
                        gcd = gcd >> 1;
                    System.out.println(gcd);
                }
            }
        }
    }

    private static ArrayList<Long> getPrimeFactors(long n)
    {
        ArrayList<Long> factors = new ArrayList<Long>();
        for(long i = 2; i <= (int)Math.sqrt(n); i++)
        {
            long counter = 0;
            while(n % i == 0)
            {
                n/= i;
                counter++;
            }
            if(counter > 0)
                factors.add(counter);
        }
        if(n != 1)
            factors.add(new Long(1));
        return factors;
    }

    public static long gcd(long a, long b)
    {
        if(b == 0 || a == 0)
            return a + b;
        return gcd(b % a, a);
    }
}