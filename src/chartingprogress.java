import java.util.ArrayList;
import java.util.Scanner;
/*
    it's pretty inefficient
    I'm pretty tired
 */
public class chartingprogress 
{
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int width = 0;
        ArrayList<Integer> table = new ArrayList<Integer>();
        loop:
        while(true)
        {
            String read;
            try
            {
                read = scan.nextLine();
            }
            catch (Exception e){break loop;}
            if(read.isEmpty())
            {
                ArrayList<String> print = new ArrayList<String>();
                int start = 0;
                for(int i : table)
                {
                    String add = "";
                    for(int position = 0; position < start; position++)
                    {
                        add += ".";
                    }
                    for(int x = 0; x < i; x++)
                    {
                        add += "*";
                    }
                    for(int x = add.length(); x < width; x++)
                    {
                        add += ".";
                    }
                    start += i;
                    print.add(add);
                }
                for(String str : print)
                {
                    System.out.println(new StringBuilder(str).reverse());
                }
                System.out.println();
                table.clear();
            }
            else
            {
                String readCopy = read.replaceAll("\\*", "");
                width = read.length();
                int count = read.length() - readCopy.length();
                table.add(count);
            }
        }
        ArrayList<String> print = new ArrayList<String>();
        int start = 0;
        for(int i : table)
        {
            String add = "";
            for(int position = 0; position < start; position++)
            {
                add += ".";
            }
            for(int x = 0; x < i; x++)
            {
                add += "*";
            }
            for(int x = add.length(); x < width; x++)
            {
                add += ".";
            }
            start += i;
            print.add(add);
        }
        for(String str : print)
        {
            System.out.println(new StringBuilder(str).reverse());
        }
        scan.close();
    }
}
