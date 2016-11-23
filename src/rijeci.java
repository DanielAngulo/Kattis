public class rijeci
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int times = scan.getInt();
        int[] count = {1, 0};
        for(int i = 0; i < times; i++)
        {
            int first = count[0];
            int second = count[1];
            count[1] = first + second;
            count[0] = second;
        }
        System.out.println(count[0] + " " + count[1]);
    }
}
