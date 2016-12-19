import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class falsesecurity
{
    static HashMap<String, String> dictionary = new HashMap<String, String>();
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        initialize();
        while(scan.hasMoreTokens())
        {
            String input = scan.getWord();
            String result = "";
            int[] lengths = new int[input.length()];
            for(int i = 0; i < input.length(); i++)
            {
                String morse = dictionary.get(input.charAt(i) + "");
                lengths[input.length() - 1 - i] = morse.length();
                result += morse;
            }
            int index = 0;
            String output = "";
            for(int n : lengths)
            {
                output += get((result.substring(index, index + n))) ;
                index += n;
            }
            System.out.println(output);
        }
        scan.close();
    }

    public static void initialize()
    {
        dictionary.put("A", ".-");
        dictionary.put("B", "-...");
        dictionary.put("C", "-.-.");
        dictionary.put("D", "-..");
        dictionary.put("E", ".");
        dictionary.put("F", "..-.");
        dictionary.put("G", "--.");
        dictionary.put("H", "....");
        dictionary.put("I", "..");
        dictionary.put("J", ".---");
        dictionary.put("K", "-.-");
        dictionary.put("L", ".-..");
        dictionary.put("M", "--");
        dictionary.put("N", "-.");
        dictionary.put("O", "---");
        dictionary.put("P", ".--.");
        dictionary.put("Q", "--.-");
        dictionary.put("R", ".-.");
        dictionary.put("S", "...");
        dictionary.put("T", "-");
        dictionary.put("U", "..-");
        dictionary.put("V", "...-");
        dictionary.put("W", ".--");
        dictionary.put("X", "-..-");
        dictionary.put("Y", "-.--");
        dictionary.put("Z", "--..");
        dictionary.put("_", "..--");
        dictionary.put(",", ".-.-");
        dictionary.put(".", "---.");
        dictionary.put("?", "----");
    }

    public static String get(String word)
    {
        for(Map.Entry<String, String> entry : dictionary.entrySet())
        {
            if(entry.getValue().equals(word))
                return entry.getKey();
        }
        return null;
    }
}
