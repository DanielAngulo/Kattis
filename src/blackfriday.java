import java.util.*;
public class blackfriday
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        scan.nextLine();
        String[] split = scan.nextLine().split(" ");
        String[] indices = Arrays.copyOf(split, split.length);
        Arrays.sort(split);
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for(int i = 0; i < amount; i++)
        {
            numbers.put(Integer.parseInt(split[i]), instancesOf(split[i], split));
        }
        ArrayList<Integer> set = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry : numbers.entrySet())
        {
            if(entry.getValue() == 1)
                set.add(entry.getKey());
        }
        if(set.size() == 0)
            System.out.println("none");
        else
        {
            int largest = set.get(set.size() - 1);
            for(int i = 0; i < amount; i++)
            {
                if(indices[i].endsWith(largest + ""))
                {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
        scan.close();
    }

    public static int instancesOf(String check, String[] strings)
    {
        int count = 0;
        for(int i = 0; i < strings.length; i++)
        {
            if(strings[i].equals(check))
            {
                count++;
                int index = i + 1;
                while(index < strings.length)
                {
                    if(strings[index].equals(check))
                        count++;
                    else
                        break;
                    index++;
                }
            }
        }
        return count;
    }
}
