public class justaminute
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int measurements = scan.getInt();
        double should = 0;
        double actual = 0;
        while(measurements-- > 0)
        {
            should += scan.getInt() * 60;
            actual += scan.getInt();
        }
        System.out.println((actual/should <= 1.0)? "measurement error": actual/should);
        scan.close();
    }
}
