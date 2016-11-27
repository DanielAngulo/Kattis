import java.util.*;

public class conversationlog
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        scan.nextLine();
        LinkedHashMap<String, Integer> words = new LinkedHashMap<String, Integer>(); //total word counts
        LinkedHashMap<String, HashSet<String>> people = new LinkedHashMap<>(); //people and the words they use
        while(amount-- > 0)
        {
            String[] input = scan.nextLine().split(" "); //0 is the name, everything else is the words they use
            HashSet<String> tempSet = new HashSet<String>(); //if the person hasn't been processed before
            if(people.containsKey(input[0]))
                tempSet = people.get(input[0]); //otherwise, use their data
            for(int i = 1; i < input.length; i++)
            {
                if(words.containsKey(input[i]))
                    words.put(input[i], words.get(input[i]) + 1);
                else
                    words.put(input[i], 1); //new word, been seen before only once
                tempSet.add(input[i]); //this person has now used this word
            }
            people.put(input[0], tempSet);
        }
        HashSet<String> masterSet = new HashSet<String>(); //words that are used by every person
        boolean initialized = false;
        for(Map.Entry<String, HashSet<String>> entry : people.entrySet())
        {
            if(!initialized)
            {
                masterSet = entry.getValue();
                initialized = true;
            }
            else
                masterSet.retainAll(entry.getValue());
        }
        if(masterSet.size() == 0)
            System.out.println("ALL CLEAR");
        else
        {
            ArrayList<Word> output = new ArrayList<Word>();
            for(String word : masterSet)
                output.add(new Word(word, words.get(word)));
            Collections.sort(output);
            for(int i = output.size() - 1; i >= 0; i--)
                System.out.println(output.get(i).word);
        }
    }
}

class Word implements Comparable<Word>
{
    String word;
    int times;

    public Word(String w, int t)
    {
        word = w;
        times = t;
    }
    @Override
    public int compareTo(Word w)
    {
        int wTimes = w.times;
        if(times > wTimes)
            return 1;
        else if(times < wTimes)
            return -1;
        return -word.compareTo(w.word); //- because it's sorted alphabetically, and we process the output from the end
    }
}