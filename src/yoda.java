/**
 * Created by Danny on 10/26/2016.
 */
public class yoda
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        String[] input = new String[]{scan.getWord(), scan.getWord()};
        int[] lengths = {input[0].length(), input[1].length()};
        while(lengths[0] < lengths[1])
        {
            input[0] = "0" + input[0];
            lengths[0]++;
        }
        while(lengths[1] < lengths[0])
        {
            input[1] = "0" + input[1];
            lengths[1]++;
        }
        String[] results = new String[]{"", ""};
        for(int i = 0; i < lengths[0]; i++)
        {
            char first = input[0].charAt(i);
            char second = input[1].charAt(i);
            if(first < second)
                results[1] += second;
            else if(second < first)
                results[0] += first;
            else
            {
                results[0] += first;
                results[1] += second;
            }
        }
        System.out.println(results[0].length() != 0? Integer.parseInt(results[0]): "YODA");
        System.out.println(results[1].length() != 0? Integer.parseInt(results[1]): "YODA");
    }
}
