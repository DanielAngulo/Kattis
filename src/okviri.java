import java.util.Scanner;

public class okviri
{
    static String[] Wendy = {"..*..", ".*.*.", "*.X.*", ".*.*.", "..*.."};
    static String[] Peter = {"..#..", ".#.#.", "#.X.#", ".#.#.", "..#.."};
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        String[] output = new String[5];
        for(int i = 0; i < 5; i++)
        {
            output[i] = "";
        }
        for(int i = 0; i < 5; i++)
        {
            output[i] += Peter[i];
        }
        output[2] = output[2].replaceAll("X", input.charAt(0) + "");
        for(int i = 1; i < input.length(); i++)
        {
            if((i + 1) % 3 == 0)
            {
                for(int x = 0; x < 5; x++)
                {
                    output[x] = output[x].substring(0, output[x].length() - 1) + Wendy[x];
                }
            }
            else
            {
                for(int x = 0; x < 5; x++)
                {
                    output[x] = output[x] + Peter[x].substring(1);
                }
            }
            output[2] = output[2].replaceAll("X", input.charAt(i) + "");
        }
        for(String print : output)
        {
            System.out.println(print);
        }
        scan.close();
    }
}
