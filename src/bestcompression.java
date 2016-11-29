import java.math.BigInteger;

public class bestcompression
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        BigInteger N = new BigInteger(scan.getWord());
        BigInteger B = new BigInteger(2 + "").pow(scan.getInt() + 1).subtract(BigInteger.ONE);
        System.out.println(N.compareTo(B) <= 0? "yes" : "no");
        scan.close();
    }

    public static BigInteger pow(int n)
    {
        BigInteger mult = new BigInteger(n + "");
        BigInteger result = new BigInteger(n + "");
        for(int i = 1; i < n; i++)
            result = result.multiply(mult);
        return result;
    }
}
