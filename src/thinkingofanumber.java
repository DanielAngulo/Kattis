import java.util.Scanner;
import java.util.ArrayList;
public class thinkingofanumber
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            int conditions = scan.nextInt();
            if(conditions == 0) break;
            Number number = new Number();
            for(int i = 0; i < conditions; i++)
            {
                String first = scan.next();
                scan.next();
                if(first.equals("less"))
                    number.setLowerBound(scan.nextInt());
                else if(first.equals("greater"))
                    number.setHigherBound(scan.nextInt());
                else
                    number.addDivisible(scan.nextInt());
            }
            System.out.println(number.printNumbers());
        }
        scan.close();
    }
}

class Number
{
    int lowerThan = 0;
    boolean changedLower = false;
    int greaterThan = 0;
    boolean changedGreater = false;
    ArrayList<Integer> divisibleBy = new ArrayList<Integer>();
    int size = 0;

    public void setLowerBound(int n)
    {
        if(!changedLower)
        {
            lowerThan = n;
            changedLower = true;
        }
        else
        {
            lowerThan = Math.min(lowerThan, n);
            changedLower = true;
        }
    }

    public void setHigherBound(int n)
    {
        if(n == 0)
            return;
        if(!changedGreater)
        {
            greaterThan = n;
            changedGreater = true;
        }
        else
        {
            greaterThan = Math.max(greaterThan, n);
            changedGreater = true;
        }
    }

    public void addDivisible(int n)
    {
        if(n != 1)
        {
            divisibleBy.add(n);
            size++;
        }
    }

    public String checkDivisible(int n)
    {
        boolean can = true;
        if(size == 0)
            return n + " ";
        else
        {
            for (int i : divisibleBy)
            {
                if (!can)
                    break;
                if (n % i != 0)
                    can = false;
            }
        }
        return(can? (n + " "): "");
    }

    public boolean check()
    {
        if(changedGreater && changedLower)
            return (greaterThan >= lowerThan);
        return false;
    }

    public String printNumbers()
    {
        String print = "";
        if(check())
            return "none";
        if(changedLower)
        {
            print = getNumbers();
            return returnPrint(print);
        }
        return "infinite";
    }

    public String getNumbers()
    {
        String print = "";
        for(int i = greaterThan + 1; i < lowerThan; i++)
            print += checkDivisible(i);
        return print.trim();
    }

    public String returnPrint(String print)
    {
        if(print.length() == 0)
            return "none";
        return print;
    }
}
