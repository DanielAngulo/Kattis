import java.util.Arrays;
public class abc
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int[] nums = {scan.getInt(), scan.getInt(), scan.getInt()};
        String order = scan.getWord();
        String indices = "ABC";
        StringBuilder output = new StringBuilder("");
        Arrays.sort(nums);
        for(int i = 0; i < 3; i++)
        {
            output.append(nums[indices.indexOf(order.charAt(i))] + " ");
        }
        scan.println(output.toString().trim());
        scan.close();
    }
}
