import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class dyslectionary
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<String>();
        int length = 0;
        while(scan.hasNextLine())
        {
            String read = scan.nextLine();
            if(read.isEmpty())
            {
                Collections.sort(words);
                for(String str : words)
                {
                    String print = "";
                    for(int i = 0; i < length - str.length(); i++)
                        print += " ";
                    System.out.println(print + (reverse(str).trim()));
                }
                length = 0;
                words = new ArrayList<String>();
                System.out.println();
            }
            else
            {
                words.add(reverse(read));
                length = Math.max(length, read.length());
            }
        }
        for(String str : words)
        {
            length = Math.max(str.length(), length);
        }
        Collections.sort(words);
        for(String str : words)
        {
            String print = "";
            for(int i = 0; i < length - str.length(); i++)
                print += " ";
            System.out.println(print + (reverse(str).trim()));
        }
        scan.close();
    }

    public static String reverse(String str)
    {
        return "" + new StringBuilder(str).reverse();
    }
}
