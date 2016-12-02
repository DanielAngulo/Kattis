import java.math.BigInteger;

public class repeatingdecimal
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        while(scan.hasMoreTokens())
        {
            BigInteger numerator = new BigInteger(scan.getInt() + ""), denominator = new BigInteger(scan.getInt() + "");
            int places = scan.getInt();
            BigInteger place = BigInteger.TEN.pow(places);
            String result = "" + (place.multiply(numerator).divide(denominator));
            String print = "0.";
            for (int i = 0; i < places - result.length(); i++)
                print += "0";
            System.out.println(print + result);
        }
    }
}
