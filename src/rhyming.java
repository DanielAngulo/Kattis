import java.util.ArrayList;
import java.util.Scanner;

public class rhyming
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String common = scan.next();
        int amount = scan.nextInt();
        scan.nextLine();
        Rhymes[] rhymes = new Rhymes[amount];
        for(int i = 0; i < amount; i++)
        {
            rhymes[i] = new Rhymes(scan.nextLine().split(" "), common);
        }
        amount = scan.nextInt();
        scan.nextLine();
        while(amount-->0)
        {
            String[] temp = scan.nextLine().split(" ");
            String check = temp[temp.length - 1];
            boolean found = false;
            boolean print = false;
            while(!found)
            {
                for(Rhymes rhyme : rhymes)
                {
                    if(rhyme.rhymes(check))
                    {
                        print |= rhyme.rhymesWithCommon;
                    }
                }
                found = true;
            }
            System.out.println(print? "YES": "NO");
        }
        scan.close();
    }
}

class Rhymes
{
    ArrayList<String> rhymes = new ArrayList<String>();
    boolean rhymesWithCommon;

    public Rhymes(String[] rhymes, String common)
    {
        for(String str : rhymes)
        {
            this.rhymes.add(str);
            if(common.endsWith(str))
                rhymesWithCommon = true;
        }
    }

    public boolean rhymes(String word)
    {
        for (String str : rhymes)
        {
            if(word.endsWith(str))
                return true;
        }
        return false;
    }
}