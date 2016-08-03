import java.math.BigInteger;
import java.util.Scanner;
public class anothercandies
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0)
        {
            scan.nextLine();
            int amount = scan.nextInt();
            BigInteger value = new BigInteger("0");
            for(int i = 0; i < amount; i++)
            {
                value = value.add(new BigInteger(scan.next()));
            }
            if(value.mod(new BigInteger(amount + "")).equals(BigInteger.ZERO))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        scan.close();
    }
}
