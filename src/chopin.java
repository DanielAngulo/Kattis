import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class chopin
{
    public static void main(String[] args)
    {
        HashMap<String, String> notes = new HashMap<>();
        notes.put("A", "");
        notes.put("A#", "Bb");
        notes.put("B", "");
        notes.put("C", "");
        notes.put("C#", "Db");
        notes.put("D", "");
        notes.put("D#", "Eb");
        notes.put("E", "");
        notes.put("F", "");
        notes.put("F#", "Gb");
        notes.put("G", "");
        notes.put("G#", "Ab");
        Scanner scan = new Scanner(System.in);
        int cases = 1;
        while(scan.hasNext())
        {
            String[] line = scan.nextLine().split(" ");
            if(notes.containsKey(line[0]))
            {
                String second = notes.get(line[0]);
                if(second.equals(""))
                    System.out.println("Case " + cases + ": UNIQUE");
                else
                    System.out.println("Case " + cases + ": " + second + " " + line[1]);
            }
            else
            {
                boolean found = false;
                while(!found)
                {
                    for(Map.Entry<String, String> entry : notes.entrySet())
                    {
                        if(entry.getValue().equals(line[0]))
                        {
                            System.out.println("Case " + cases + ": " + entry.getKey() + " " + line[1]);
                            found = true;
                        }
                    }
                }
            }
            cases++;
        }
        scan.close();
    }
}
