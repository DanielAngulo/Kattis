import java.util.HashMap;

public class haypoints
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        HashMap<String, Integer> hayPoints =  new HashMap<String, Integer>();
        int words = scan.getInt(), paragraphs = scan.getInt();
        for(int i = 0; i < words; i++)
            hayPoints.put(scan.getWord(), scan.getInt());
        for(int i = 0; i < paragraphs; i++)
        {
            long value = 0;
            paragraph:
            while(true)
            {
                String word = scan.getWord();
                if(word.equals("."))
                    break paragraph;
                if(hayPoints.containsKey(word))
                    value += hayPoints.get(word);
            }
            scan.println(value);
        }
        scan.close();
    }
}
