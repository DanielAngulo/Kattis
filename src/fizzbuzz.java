public class fizzbuzz
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int x = scan.getInt(), y = scan.getInt(), n = scan.getInt();
        for(int i = 1; i <= n; i++)
        {
            if(i % x == 0 && i % y == 0)
                scan.println("FizzBuzz");
            else if(i % x == 0)
                scan.println("Fizz");
            else if(i % y == 0)
                scan.println("Buzz");
            else
                scan.println(i);
        }
        scan.close();
    }
}
