import java.util.ArrayList;

/**
 * Created by Danny on 2/26/2017.
 */
public class primereduction
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        while(scan.hasMoreTokens())
        {
            int n = scan.getInt();
            if(n == 4)
                break;
            System.out.println(primeFactor(n, 1));
        }
        scan.close();
    }

    public static String primeFactor(int n, int times)
    {
        int original = n;
        if(isPrime(n))
        {
            return n + " " + times;
        }
        int sqrt = (int)Math.sqrt(n) + 1;
        int x = 0;
        for(int i = 2; i <= n/i; i++)
        {
            while(n % i == 0)
            {
                n/= i;
                x += i;
            }
        }
        if(n > 1)
            x += n;
        if(x == original)
            return x + " " + times;
        return primeFactor(x, times + 1);
    }

    public static boolean isPrime(int n)
    {
        if(n == 1)
            return false;
        if(n == 2)
            return true;
        if(n % 2 == 0)
            return false;
        int half = (int)Math.sqrt(n) + 1;
        for(int i = 3; i <= half; i+= 2)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
