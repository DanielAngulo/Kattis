import java.util.ArrayList;
import java.util.Scanner;
public class skener
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        int zRows = scan.nextInt();
        int zColumns = scan.nextInt();
        scan.nextLine();
        ArrayList<String> board = new ArrayList<String>();
        int length = rows * zRows;
        for(int i = 0; i < length; i++)
            board.add("");
        int current = 0;
        for(int i = 0; i < rows; i++)
        {
            String input = scan.nextLine();
            String add = "";
            for(int x = 0; x < input.length(); x++)
            {
                for(int y = 0; y < zColumns ; y++)
                    add += input.charAt(x);
            }
            for(int x = 0; x < zRows; x++)
            {
                board.set(current, add);
                current++;
            }
        }
        for(String str : board)
            System.out.println(str);
        scan.close();
    }
}
