import java.util.ArrayDeque;
import java.util.Arrays;

public class grid
{
    static class Point
    {
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int rows = scan.getInt(), cols = scan.getInt();
        int[][] grid = new int[rows][cols];
        int[][] steps = new int[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            Arrays.fill(steps[i], -1);
            String input = scan.getWord();
            for(int x = 0; x < cols; x++)
            {
                grid[i][x] = Integer.parseInt("" + input.charAt(x));
            }
        }
        steps[0][0] = 0;
        ArrayDeque<Point> queue = new ArrayDeque<Point>();
        queue.add(new Point(0, 0));
        while(!queue.isEmpty())
        {
            Point remove = queue.removeFirst();
            int x = remove.x, y = remove.y;
            int dist = steps[x][y] + 1;
            int amount = grid[x][y];
            if(x - amount >= 0 && steps[x - amount][y] == -1)
            {
                steps[x - amount][y] = dist;
                queue.add(new Point(x - amount, y));
            }
            if(x + amount < rows && steps[x + amount][y] == -1)
            {
                steps[x + amount][y] = dist;
                queue.add(new Point(x + amount, y));
            }
            if(y - amount >= 0 && steps[x][y - amount] == -1)
            {
                steps[x][y - amount] = dist;
                queue.add(new Point(x, y - amount));
            }
            if(y + amount < cols && steps[x][y + amount] == -1)
            {
                steps[x][y + amount] = dist;
                queue.add(new Point(x, y + amount));
            }
        }
        scan.println(steps[rows - 1][cols - 1]);
        scan.close();
    }
}
