import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class natrij
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try
        {
            int first = Integer.parseInt(scan.next().replaceAll(":", ""));
            int second = Integer.parseInt(scan.next().replaceAll(":", ""));
            if(first > second)
            {
                second += 240000;
            }
            String date = first + "";
            for(int i = date.length(); i < 6; i++)
            {
                date = "0" + date;
            }
            date = date.substring(0, 2) + ":" + date.substring(2, 4) + ":" + date.substring(4);
            Date date1 = format.parse(date);
            date = second + "";
            for(int i = date.length(); i < 6; i++)
            {
                date = "0" + date;
            }
            date = date.substring(0, 2) + ":" + date.substring(2, 4) + ":" + date.substring(4);
            Date date2 = format.parse(date);
            int millis = (int)(date2.getTime() - date1.getTime());
            long hours = TimeUnit.MILLISECONDS.toHours(millis);
            millis -= TimeUnit.HOURS.toMillis(hours);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
            millis -= TimeUnit.MINUTES.toMillis(minutes);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
            String print = String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
            if(print.equals("00:00:00"))
                System.out.println("24:00:00");
            else
                System.out.println(print);
        }
        catch (Exception e){;}
    }
}
