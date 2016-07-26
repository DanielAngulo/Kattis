import java.util.ArrayList;
import java.util.Scanner;
public class beekeeper
{
    static String vowels = "aeiouy";
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            int amount = scan.nextInt();
            if(amount == 0) break;
            int most = 0;
            String mostString = "";
            ArrayList<String> words = new ArrayList<String>();
            boolean found = false;
            for(int i = 0; i < amount; i++)
            {
                String str = scan.next();
                words.add(str);
                int temp = getDoubleVowelsAmount(str);
                if(temp > 0)
                {
                    if(!found)
                    {
                        most = temp;
                        mostString = str;
                        found = true;
                    }
                    else if(most < temp)
                    {
                        mostString = str;
                        most = temp;
                    }
                }
            }
            if(!found)
                System.out.println(words.get(0));
            else
                System.out.println(mostString);
        }
        scan.close();
    }

    public static int getDoubleVowelsAmount(String str)
    {
        int amount = 0;
        int length = str.length();
        for(int i = 0; i < length - 1; i++)
        {
            if(vowels.contains(str.charAt(i) + ""))
            {
                if(str.charAt(i + 1) == str.charAt(i))
                {
                    amount++;
                    i++;
                }
            }
        }
        return amount;
    }
}
