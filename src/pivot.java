import java.util.Arrays;

public class pivot
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int input = scan.getInt();
        int max = scan.getInt();
        PivotPoint[] array = new PivotPoint[input];
        array[0] = new PivotPoint(max, true);
        for(int i = 1; i < input; i++)
        {
            int temp = scan.getInt();
            if(temp >= max)
                array[i] = new PivotPoint(temp, true);
            else
                array[i] = new PivotPoint(temp, false);
            max = Math.max(temp, max);
        }
        int[] maxArray = new int[input];
        int[] minArray = new int[input];
        max = array[input - 1].n;
        int min = max;
        maxArray[input - 1] = max;
        minArray[input - 1] = max;
        for(int i = input - 2; i >= 0; i--)
        {
            max = Math.max(array[i].n, max);
            maxArray[i] = max;
            min = Math.min(array[i].n, min);
            minArray[i] = min;
        }
        int count = 0;
        for(int i = 1; i < input - 1; i++)
        {
            if(array[i].valid)
            {
                if(!(minArray[i + 1] <= array[i].n) && maxArray[i + 1] > array[i].n)
                    count++;
            }
        }
        if(maxArray[1] > array[0].n && !(minArray[1] <= array[0].n))
            count++;
        if(minArray[input - 2] < array[input - 1].n)
            count++;
        System.out.println(count);
        scan.close();
    }
}

class PivotPoint
{
    int n = 0;
    boolean valid = true;

    public PivotPoint(int n, boolean b)
    {
        this.n = n;
        valid = b;
    }

    public String toString()
    {
        return n + "";
    }
}
