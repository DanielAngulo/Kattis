import java.util.Arrays;

public class cetiri
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int[] numbers = {scan.getInt(), scan.getInt(), scan.getInt()};
        Arrays.sort(numbers);
        int diff = numbers[1] - numbers[0], diff2 = numbers[2] - numbers[1];
        if(diff == diff2)
            scan.println(numbers[2] + diff);
        else
        {
            if(diff < diff2)
            {
                scan.println(numbers[1] + diff);
            }
            else
            {
                scan.println(numbers[0] + diff2);
            }
        }
        scan.close();
    }
}
