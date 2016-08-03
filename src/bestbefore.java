import java.util.Scanner;
import java.util.ArrayList;
public class bestbefore
{
    static int[] possible = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String scanned = scan.next();
        scan.close();
        int[] values = parseSplit(scanned.split("/"));
        ArrayList<Date> list = new ArrayList<Date>();
        list.add(new Date(values[0], values[1], values[2]));
        list.add(new Date(values[0], values[2], values[1]));
        list.add(new Date(values[1], values[0], values[2]));
        list.add(new Date(values[1], values[2], values[0]));
        list.add(new Date(values[2], values[0], values[1]));
        list.add(new Date(values[2], values[1], values[0]));
        for(int i = 0; i < list.size(); i++)
        {
            if(!list.get(i).isValid())
            {
                list.remove(i);
                i--;
            }
        }
        if(list.size() == 0)
            System.out.println(scanned + " is illegal");
        else
        {
            sort(list);
            System.out.println(list.get(0));
        }
    }

    public static void sort(ArrayList<Date> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.size() - 1; j++)
            {
                if(list.get(j).compareTo(list.get(j + 1)) > 0)
                {
                    Date temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static int[] parseSplit(String[] split)
    {
        int[] values = new int[split.length];
        for(int i = 0; i < split.length; i++)
            values[i] = Integer.parseInt(split[i]);
        return values;
    }
}

class Date
{
    int day;
    int month;
    int year;

    public Date(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValid()
    {
        if(month == 2 && day == 29)
        {
            if(year % 4 != 0)
                return false;
            if(year % 100 == 0)
                return year % 400 == 0;
            else
                return true;
        }
        if(day == 0 || month == 0)
            return false;
        if(month > 12)
            return false;
        if(day > bestbefore.possible[month])
            return false;
        return true;
    }

    public int compareTo(Date d)
    {
        if(d.year < this.year)
            return 1;
        else if(d.year > this.year)
            return -1;
        else
        {
            if(d.month < this.month)
                return 1;
            else if(d.month > this.month)
                return -1;
            else
            {
                if(d.day < this.day)
                    return 1;
                else if(d.day > this.day)
                    return -1;
                return 0;
            }
        }
    }

    public String toString()
    {
        String date = "";
        String temp = this.year + "";
        if(temp.length() == 1)
            temp = "200" + temp;
        else if(temp.length() == 2)
            temp = "20" + temp;
        date = temp + "-";
        if(month < 10)
            date += "0";
        date += month + "-";
        if(day < 10)
            date += "0";
        date += day + "";
        return date;
    }
}