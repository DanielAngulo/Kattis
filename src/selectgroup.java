import java.util.*;

public class selectgroup
{
    static HashMap<String, TreeSet<String>> groups = new HashMap<String, TreeSet<String>>();
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine())
        {
            String[] input = scan.nextLine().split(" ");
            if(input[0].equals("group"))
            {
                String name = input[1];
                TreeSet<String> group = new TreeSet<String>();
                for(int i = 3; i < input.length; i++)
                {
                    group.add(input[i]);
                }
                groups.put(name, group);
            }
            else
            {
                input = reverse(input);
                int length = input.length;
                ArrayDeque<TreeSet<String>> stack = new ArrayDeque<>();
                for(int i = 0; i < length; i++)
                {
                    String operation = input[i];
                    if(operation.equals("intersection"))
                    {
                        TreeSet<String> first = new TreeSet<>(stack.removeFirst());
                        TreeSet<String> second = new TreeSet<>(stack.removeFirst());
                        first.retainAll(second);
                        stack.push(first);
                    }
                    else if(operation.equals("union"))
                    {
                        TreeSet<String> first = new TreeSet<>(stack.removeFirst());
                        TreeSet<String> second = new TreeSet<>(stack.removeFirst());
                        first.addAll(second);
                        stack.push(first);
                    }
                    else if(operation.equals("difference"))
                    {
                        TreeSet<String> first = new TreeSet<>(stack.removeFirst());
                        TreeSet<String> second = new TreeSet<>(stack.removeFirst());
                        first.removeAll(second);
                        stack.push(first);
                    }
                    else
                    {
                        stack.push(groups.get(operation));
                    }
                }
                StringBuilder result = new StringBuilder("");
                for(String str : stack.getFirst())
                {
                    result.append(str + ",");
                }
                System.out.println(result.toString().replaceAll(",", " ").trim());
            }
        }
    }

    public static String[] reverse(String[] array)
    {
        String[] newArray = new String[array.length];
        int index = 0;
        for(int i = array.length - 1; i >= 0; i--)
        {
            newArray[index] = array[i];
            index++;
        }
        return newArray;
    }
}
