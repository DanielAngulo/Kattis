public class R2
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int[] input = {scan.getInt(), scan.getInt()};
        scan.println(input[1] * 2 - input[0]);
        scan.close();
    }
}
