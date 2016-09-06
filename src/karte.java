import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class karte
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        scan.close();
        String check = "PKHT";
        boolean error = false;
        ArrayList<HashSet<Integer>> cards = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < 4; i++)
            cards.add(new HashSet<Integer>());
        for(int i = 0; i < input.length(); i += 3)
        {
            char suit = input.charAt(i);
            int value = Integer.parseInt(input.substring(i + 1, i + 3));
            int index = check.indexOf(suit);
            if(cards.get(index).contains(value))
            {
                error = true;
                break;
            }
            else
                cards.get(index).add(value);
        }
        if(error)
            System.out.println("GRESKA");
        else
        {
            String output = "";
            for(int i = 0; i < 4; i++)
                output += 13 - cards.get(i).size() + " ";
            System.out.println(output.trim());
        }
    }
}
