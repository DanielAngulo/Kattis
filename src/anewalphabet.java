import java.util.HashMap;
import java.util.Scanner;
public class anewalphabet
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> alphabet = new HashMap<>();
        setAlphabet(alphabet);
        String input = scan.nextLine().toUpperCase();
        for(int i = 0; i < input.length(); i++)
        {
            if(alphabet.containsKey(input.charAt(i) + ""))
                System.out.print(alphabet.get(input.charAt(i) + ""));
            else
                System.out.print(input.charAt(i));
        }
        scan.close();
    }

    public static void setAlphabet(HashMap<String, String> map)
    {
        map.put("A", "@");
        map.put("B", "8");
        map.put("C", "(");
        map.put("D", "|)");
        map.put("E", "3");
        map.put("F", "#");
        map.put("G", "6");
        map.put("H", "[-]");
        map.put("I", "|");
        map.put("J", "_|");
        map.put("K", "|<");
        map.put("L", "1");
        map.put("M", "[]\\/[]");
        map.put("N", "[]\\[]");
        map.put("O", "0");
        map.put("P", "|D");
        map.put("Q", "(,)");
        map.put("R", "|Z");
        map.put("S", "$");
        map.put("T", "']['");
        map.put("U", "|_|");
        map.put("V", "\\/");
        map.put("W", "\\/\\/");
        map.put("X", "}{");
        map.put("Y", "`/");
        map.put("Z", "2");
    }
}
