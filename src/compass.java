/*
    Don't judge, I am very bad at math
    No juzguéis, soy malo en matemáticas
 */

import java.util.Scanner;
public class compass
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int current = scan.nextInt();
        int correct = scan.nextInt();
        int output = 0;
        if(current < correct)
        {
            int[] options = {correct - current, current + (360 - correct)};
            if(Math.min(options[0], Math.abs(options[1])) == options[0])
              output = (options[0]);
            else
                output = (-options[1]);
        }
        else
        {
            int temp = correct;
            correct = current;
            current = temp;
            int[] options = {correct - current, current + (360 - correct)};
            if(Math.min(options[0], Math.abs(options[1])) == options[0])
                output = (-options[0]);
            else
                output = (options[1]);
        }
        if(output == -180)
            output = -output;
        System.out.println(output);
        scan.close();
    }
}
