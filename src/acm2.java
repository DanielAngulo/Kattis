import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class acm2
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        int first = scan.nextInt();
        ArrayList<Integer> questions = new ArrayList<Integer>();
        for(int i = 0; i < amount; i++)
        {
            questions.add(scan.nextInt());
        }
        if(300 - questions.get(first) < 0)
            System.out.println("0 0");
        else
        {
            int solved = 1;
            int penalty = questions.remove(first);
            int timeLeft = 300 - penalty;
            Collections.sort(questions);
            for(int n : questions)
            {
                if(timeLeft - n < 0)
                    break;
                solved++;
                timeLeft -= n;
                penalty += (300 - timeLeft);
            }
            System.out.println(solved + " " + penalty);
        }
    }
}
