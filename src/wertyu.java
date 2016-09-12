import java.util.Scanner;
public class wertyu
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] characters = {"`1234567890-=", ("QWERTYUIOP[]" + "\\"), "ASDFGHJKL;'", "ZXCVBNM,./"};
        while(scan.hasNextLine())
        {
            String str = scan.nextLine();
            String result = "";
            for(int i = 0; i < str.length(); i++)
            {
                if(str.charAt(i) == ' ')
                    result += " ";
                else
                {
                    for(int x = 0; x < 4; x++)
                    {
                        if(characters[x].contains(str.charAt(i) + ""))
                        {
                            result += characters[x].charAt(characters[x].indexOf(str.charAt(i) + "") - 1);
                            x = 3;
                        }
                    }
                }
            }
            System.out.println(result);
        }
        scan.close();
    }
}
