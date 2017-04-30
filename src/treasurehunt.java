import java.util.Scanner;

public class treasurehunt
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt(), c = scan.nextInt();
        char[][] map = new char[r][c];
        boolean[][] visited = new boolean[r][c];
        scan.nextLine();
        for(int i = 0; i  < r; i++)
        {
            map[i] = scan.nextLine().toCharArray();
        }
        int x = 0, y = 0, steps = 0;
        char instruction;
        boolean forever = false;
        boolean out = false;
        loop:
        while(true)
        {
            if(x < 0 || x >= r || y < 0 || y >= c)
            {
                out = true;
                break loop;
            }
            if(visited[x][y])
            {
                forever = true;
                break loop;
            }
            visited[x][y] = true;
            instruction = map[x][y];
            steps++;
            if(instruction == 'N')
                x--;
            else if(instruction == 'S')
                x++;
            else if(instruction == 'E')
                y++;
            else if(instruction == 'W')
                y--;
            else
            {
                break loop;
            }
        }
        if(forever)
            System.out.println("Lost");
        else if(out)
            System.out.println("Out");
        else
            System.out.println(steps - 1);
        scan.close();
    }
}