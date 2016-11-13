public class grassseed
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        double cost = scan.getDouble();
        double result = 0;
        int amount = scan.getInt();
        while(amount-->0)
            result += cost * (scan.getDouble() * scan.getDouble());
        scan.printf("%.7f", result);
        scan.close();
    }
}
