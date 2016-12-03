import java.util.Arrays;
import java.util.Scanner;
public class timebomb
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] digits = new String[5];
        for(int i = 0; i < 5; i++)
            digits[i] = scan.nextLine() +" ";
        int length = digits[0].length();
        int times = length/4;
        String check = "";
        boolean can = true;
        loop:
        for(int i = 0; ; i++)
        {
            try
            {
                int index = i * 4;
                String[] temp = new String[5];
                for(int x = 0; x < 5; x++)
                    temp[x] = digits[x].substring(index, index + 3);
                String getNum = getNum(temp);
                if(getNum == null)
                {
                    can = false;
                    i = times + 1;
                }
                else
                    check += getNum(temp);
            }
            catch (Exception e) {break loop;}
        }
        if(!can)
            System.out.println("BOOM!!");
        else
            System.out.println(Integer.parseInt(check) % 6 == 0? "BEER!!" : "BOOM!!");
        scan.close();
    }

    public static String getNum(String[] array)
    {
        /*
        Get ready to see some shit code
        Preparaos para ver código horrible
         */
        if(array[0].equals("***") && array[1].equals("* *") && array[2].equals("* *") && array[3].equals("* *") && array[4].equals("***"))
            return "0";
        if(array[0].equals("  *") && array[1].equals("  *") && array[2].equals("  *") && array[3].equals("  *") && array[4].equals("  *"))
            return "1";
        if(array[0].equals("***") && array[1].equals("  *") && array[2].equals("***") && array[3].equals("*  ") && array[4].equals("***"))
            return "2";
        if(array[0].equals("***") && array[1].equals("  *") && array[2].equals("***") && array[3].equals("  *") && array[4].equals("***"))
            return "3";
        if(array[0].equals("* *") && array[1].equals("* *") && array[2].equals("***") && array[3].equals("  *") && array[4].equals("  *"))
            return "4";
        if(array[0].equals("***") && array[1].equals("*  ") && array[2].equals("***") && array[3].equals("  *") && array[4].equals("***"))
            return "5";
        if(array[0].equals("***") && array[1].equals("*  ") && array[2].equals("***") && array[3].equals("* *") && array[4].equals("***"))
            return "6";
        if(array[0].equals("***") && array[1].equals("  *") && array[2].equals("  *") && array[3].equals("  *") && array[4].equals("  *"))
            return "7";
        if(array[0].equals("***") && array[1].equals("* *") && array[2].equals("***") && array[3].equals("* *") && array[4].equals("***"))
            return "8";
        if(array[0].equals("***") && array[1].equals("* *") && array[2].equals("***") && array[3].equals("  *") && array[4].equals("***"))
            return "9";
        return null;
    }
}
