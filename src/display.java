import java.util.ArrayList;

public class display
{
    static ArrayList<ArrayList<String>> numbers = new ArrayList<ArrayList<String>>();
    static ArrayList<String> colon = new ArrayList<String>();
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        initialize();
        while(true)
        {
            String input = scan.getWord();
            if(input.equals("end"))
                break;
            ArrayList<String> result = new ArrayList<String>();
            for(int i = 0; i < 7; i++)
                result.add("");
            for(int i = 0; i < 5; i++)
            {
                try
                {
                    ArrayList<String> temp = numbers.get(Integer.parseInt(input.charAt(i) + ""));
                    if(i != 5)
                        append(result, temp);
                    else
                        appendLast(result, temp);
                }
                catch(Exception e)
                {
                    append(result, colon);
                }
            }
            for(int i = 0; i < result.size(); i++)
            {
                String print = result.get(i).substring(1);
                while(print.endsWith(" "))
                    print = print.substring(0, print.length() - 1);
                for(int x = print.length(); x < 29; x++)
                    print += " ";
                System.out.println(print);
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("end");
        scan.close();
    }

    public static void initialize()
    {
        for(int i = 0; i < 10; i++)
            numbers.add(setArrayList(i));
        colon.add(" ");
        colon.add(" ");
        colon.add("o");
        colon.add(" ");
        colon.add("o");
        colon.add(" ");
        colon.add(" ");

    }

    public static ArrayList<String> setArrayList(int i)
    {
        ArrayList<String> add = new ArrayList<String>();
        switch(i)
        {
            case(0):
            {
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                        add.add("|   |");
                add.add("+   +");
                for(int j = 0; j < 2; j++)
                    add.add("|   |");
                add.add("+---+");
            }
            case(1):
            {
                add.add("    +");
                for(int j = 0; j < 2; j++)
                {
                    for(int x = 0; x < 2; x++)
                        add.add("    |");
                    add.add("    +");
                }
            }
            case(2):
            {

                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("    |");
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("|    ");
                add.add("+---+");
            }
            case(3):
            {
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("    |");
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("    |");
                add.add("+---+");
            }
            case(4):
            {
                add.add("+   +");
                for(int j = 0; j < 2; j++)
                    add.add("|   |");
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("    |");
                add.add("    +");
            }
            case(5):
            {
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("|    ");
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("    |");
                add.add("+---+");
            }
            case(6):
            {
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("|    ");
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("|   |");
                add.add("+---+");
            }
            case(7):
            {
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("    |");
                add.add("    +");
                for(int j = 0; j < 2; j++)
                    add.add("    |");
                add.add("    +");
            }
            case(8):
            {
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("|   |");
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("|   |");
                add.add("+---+");
            }
            case(9):
            {
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("|   |");
                add.add("+---+");
                for(int j = 0; j < 2; j++)
                    add.add("    |");
                add.add("+---+");
            }
        }
        return add;
    }

    public static void append(ArrayList<String> save, ArrayList<String> add)
    {
        for(int i = 0; i < 7; i++)
        {
            save.set(i, save.get(i) + " " + add.get(i) + " ");
        }
    }

    public static void appendLast(ArrayList<String> save, ArrayList<String> add)
    {
        for(int i = 0; i < 7; i++)
        {
            save.set(i, save.get(i) + " " + add.get(i));
        }
    }
}