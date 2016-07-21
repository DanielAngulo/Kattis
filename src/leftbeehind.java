import java.util.Scanner;
public class leftbeehind
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            int sweet = scan.nextInt();
            int sour = scan.nextInt();
            if(sweet + sour == 0)
                break;
            if(sweet + sour == 13)
                System.out.println("Never speak again.");
            else if(sweet < sour)
                System.out.println("Left beehind.");
            else if(sweet == sour)
                System.out.println("Undecided.");
            else
                System.out.println("To the convention.");
        }
        scan.close();
    }
}
