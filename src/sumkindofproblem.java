public class sumkindofproblem
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int amount = scan.getInt();
        while(amount-- > 0)
        {
            int num = scan.getInt();
            int calc = scan.getInt();
            System.out.println(num + " " + get(calc) + " " + getOdd(calc) + " " + getEven(calc));
        }
        scan.close();
    }

    public static long get(int n)
    {
        long sum = 0;
        for(int i = 1; i <= n; i++)
            sum += i;
        return sum;
    }

    public static long getOdd(int n)
    {
        long sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += (2* i) + 1;
        }
        return sum;
    }

    public static long getEven(int n)
    {
        int first = 2;
        long sum = 0;
        for(int i = 1; i <= n; i++)
        {
            sum += first * i;
        }
        return sum;
    }
}
