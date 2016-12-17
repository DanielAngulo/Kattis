import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class classy
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(cases-- > 0)
        {
            int amount = scan.nextInt();
            scan.nextLine();
            Person[] people = new Person[amount];
            int maxLength = 0;
            for(int i = 0; i < amount; i++)
            {
                String read = scan.nextLine();
                String[] input = read.split(" ");
                String name = input[0].substring(0, input[0].length() - 1);
                String[] categories = input[1].split("-");
                maxLength = Math.max(maxLength, categories.length);
                people[i] = new Person(name, categories);
            }
            for(int i = 0; i < amount; i++)
                people[i].rank = Person.toRankString(people[i].category, maxLength);
            Arrays.sort(people);
            for(int i = amount - 1; i >= 0; i--)
                System.out.println(people[i].name);
            System.out.println("==============================");
        }
        scan.close();
    }
}

class Person implements Comparable<Person>
{
    String name = "";
    String[] category = null;
    String rank = "";

    public Person(String name, String[] category)
    {
        this.name = name;
        this.category = category;
    }

    public static String toRankString(String[] category, int maxLength)
    {
        String result = "";
        for(String current : category)
        {
            if(current.equals("upper"))
                result += "2";
            else if(current.equals("middle"))
                result += "1";
            else
                result += "0";
        }
        result = "" + (new StringBuilder(result).reverse());
        for(int i = result.length(); i < maxLength; i++)
            result += "1";
        return result;
    }

    @Override
    public int compareTo(Person p)
    {
        if(p.rank.equals(rank))
        {
            return (p.name.compareTo(name));
        }
        else
            return rank.compareTo(p.rank);
    }
}
