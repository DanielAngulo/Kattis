public class tarifa
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int limit = scan.getInt();
        int months = scan.getInt();
        int leftOver = limit;
        while(months-- > 0)
        {
            int n = scan.getInt();
            if(n <= limit)
            {
                leftOver += (limit - n);
            }
            else
            {
                if(n > limit)
                {
                    leftOver -= (n - limit);
                }
                else
                {
                    leftOver += (limit - n);
                }
            }
        }
        scan.println(leftOver);
        scan.close();
    }
}
