import java.util.Scanner;

public class filip
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String first = new StringBuilder(scan.next()).reverse().toString(), second = new StringBuilder(scan.next()).reverse().toString();
        System.out.println(first.compareTo(second) > 0 ? first : second);
        scan.close();
    }
}
