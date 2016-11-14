import java.util.ArrayList;
public class bing
{
    static ArrayList<String> words = new ArrayList<String>();
    public static void main(String[] args)
    {

        Kattio scan = new Kattio(System.in, System.out);
        int amount = scan.getInt();
        while(amount-- > 0)
        {
            String word = scan.getWord();
            int index = add(word);
            words.add(index, word);
            System.out.println(startWith(index + 1, word));
        }
        scan.close();
    }

    public static int add(String word)
    {
        int size = words.size();
        if(size == 0)
            return 0;
        if(size < 9)
        {
            for(int i = 0; i < size;i++)
            {
                if(word.compareTo(words.get(i)) <= 0)
                    return i;
            }
        }
        if(word.compareTo(words.get(size - 1)) > 0)
            return size;
        int reps = (int)(Math.log(size)/Math.log(2)) - 3;
        int low = 0;
        int up = size;
        for(int i = 0; i < reps; i++)
        {
            int mid = (up + low)/2;
            if(word.compareTo(words.get(mid)) <= 0)
                up = mid;
            else
                low = mid;
        }
        for(int i = low; i <= up; i++)
        {
            try
            {
                if(word.compareTo(words.get(i)) <= 0)
                    return i;
            }
            catch(Exception e){}
        }
        return -1;
    }

    public static int startWith(int index, String word)
    {
        int count = 0;
        int size = words.size();
        for(int i = index; i < size; i++)
        {
            if(words.get(i).startsWith(word))
                count++;
            else
                return count;
        }
        return count;
    }
}
