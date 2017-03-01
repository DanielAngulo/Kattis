import java.util.ArrayDeque;
public class backspace
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        char[] input = (scan.getWord() ).toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < input.length; i++)
        {
            if(input[i] != '<')
            {
                stack.add(input[i]);
            }
            else
                stack.removeLast();
        }
        String print = ("" + stack);
        print = print.substring(1, print.length() -1);
        print = print.replaceAll(", ", "");
        System.out.println(print);
    }
}