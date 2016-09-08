import java.util.Scanner;
import java.util.ArrayList;
public class eightqueens
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        char[][] board = new char[8][8];
        ArrayList<Location> queens = new ArrayList<Location>();
        for(int i = 0; i < 8; i++)
            board[i] = scan.nextLine().toCharArray();
        for(int i = 0; i < 8; i++)
        {
            for(int x = 0; x < 8; x++)
            {
                if(board[i][x] == '*')
                    queens.add(new Location(i, x));
            }
        }
        if(queens.size() != 8 || sameRow(queens) || diagonal(queens, board))
            System.out.println("invalid");
        else
            System.out.println("valid");
        scan.close();
    }

    public static boolean sameRow(ArrayList<Location> queens)
    {
        for(int i = 0; i < queens.size() - 1; i++)
        {
            for(int x = i + 1; x < queens.size(); x++)
            {
                if(queens.get(i).x == queens.get(x).x || queens.get(x).y == queens.get(i).y)
                    return true;
            }
        }
        return false;
    }

    public static boolean diagonal(ArrayList<Location> queens, char[][] board)
    {
        for(Location L : queens)
        {
            int x = L.x;
            int y = L.y;
            //Down = x - 1
            //Up = x + 1
            //Left = y - 1
            //Right = y + 1
            while(x > 0 && y > 0)
            {
                x--;
                y--;
                if(board[x][y] == '*')
                    return true;
            }
            x = L.x;
            y = L.y;
            while(x > 0 && y < 7)
            {
                x--;
                y++;
                if(board[x][y] == '*')
                    return true;
            }
            x = L.x;
            y = L.y;
            while(x < 7 && y > 0)
            {
                x++;
                y--;
                if(board[x][y] == '*')
                    return true;
            }
            x = L.x;
            y = L.y;
            while(x < 7 && y < 7)
            {
                x++;
                y++;
                if(board[x][y] == '*')
                    return true;
            }
        }
        return false;
    }
}

class Location
{
    int x;
    int y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Location l)
    {
        return x == this.x && y == this.y;
    }
}