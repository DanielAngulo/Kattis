import java.util.Arrays;

public class plantingtrees
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int trees = scan.getInt();
        int[] times = new int[trees];
        for(int i = 0; i < trees; i++)
            times[i] = scan.getInt();
        Arrays.sort(times);
        times = reverse(times);
        int timeTakes = times[0];
        int timeLeft = timeTakes;
        for(int i : times)
        {
            timeLeft--;
            if(timeLeft < i)
            {
                timeTakes += (i - timeLeft);
                timeLeft = i;
            }
        }
        System.out.println(timeTakes + 1);
    }

    public static int[] reverse(int[] array)
    {
        int[] newArray = new int[array.length];
        for(int i = 0; i < array.length; i++)
            newArray[array.length - 1 - i] = array[i];
        return newArray;
    }
}
