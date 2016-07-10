import java.util.Scanner;
import java.util.Arrays;
public class kornislav 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int[] sides = {scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()};
        Arrays.sort(sides);
        System.out.println(sides[0] * sides[2]);
        scan.close();
    }
}
