import java.util.Scanner;

public class datum
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[] names = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = scan.nextInt(), month = scan.nextInt();
        int soFar = 0;
        for(int i = 0; i < month -1; i++)
        {
            soFar += days[i];
        }
        soFar += day;
        System.out.println(names[(soFar + 2) % 7]); //For some reason, it is set to Tuesday by default. 1/1/09 is Tuesday.
        scan.close();
    }
}
