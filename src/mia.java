import java.util.Scanner;
import java.util.Arrays;
public class mia
{
    static final String one = "Player 1 wins.";
    static final String two = "Player 2 wins.";
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            int[] player1 = {scan.nextInt(), scan.nextInt()};
            int[] player2 = {scan.nextInt(), scan.nextInt()};
            if(player1[0] + player1[1] + player2[0] + player2[1] == 0)
                break;
            Arrays.sort(player1);
            Arrays.sort(player2);
            int p1 = getScore(player1);
            int p2 = getScore(player2);
            if(p1 == p2)
                System.out.println("Tie.");
            else if(p1 == 12)
                System.out.println(one);
            else if(p2 == 12)
                System.out.println(two);
            else
            {
                boolean p1d = isDouble(p1);
                boolean p2d = isDouble(p2);
                if((p1d && p2d) || (!p1d && !p2d))
                {
                    if(p1 > p2)
                        System.out.println(one);
                    else
                        System.out.println(two);
                }
                else if(p1d)
                    System.out.println(one);
                else if(p2d)
                    System.out.println(two);
            }
        }
        scan.close();
    }

    public static int getScore(int[] array)
    {
        if(array[0] == 1 && array[1] == 2)
            return 12;
        return (array[1] * 10) + array[0];
    }

    public static boolean isDouble(int n)
    {
        return n/10 == n % 10;
    }
}
