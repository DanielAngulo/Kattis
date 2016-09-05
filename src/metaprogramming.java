import java.util.HashMap;
import java.util.Scanner;

public class metaprogramming
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> variables = new HashMap<>();
        while(scan.hasNext())
        {
            String[] input = scan.nextLine().split(" ");
            if(input[0].equals("define"))
                variables.put(input[2], Integer.parseInt(input[1]));
            else
            {
                if(!variables.containsKey(input[1]) || !variables.containsKey(input[3]))
                    System.out.println("undefined");
                else
                {
                    int value1 = variables.get(input[1]);
                    int value2 = variables.get(input[3]);
                    char comparison = input[2].charAt(0);
                    switch (comparison)
                    {
                        case('<'):System.out.println(value1 < value2);
                            break;
                        case('='):System.out.println(value1 == value2);
                            break;
                        case('>'):System.out.println(value1 > value2);
                            break;
                    }
                }
            }
        }
        scan.close();
    }
}
