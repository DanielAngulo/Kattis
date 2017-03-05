import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.ArrayList;

public class fire2
{
    static ArrayList<char[][]> maps = new ArrayList<char[][]>();
    static int rows, cols;

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
        Kattio scan = new Kattio(System.in);
        int cases = scan.getInt();
        while(cases-- > 0)
        {
            maps = new ArrayList<char[][]>();
            cols = scan.getInt();
            rows = scan.getInt();
            char[][] map = new char[rows][cols];
            Point start = new Point(-1, -1);
            int[][] distances = new int[rows][cols];
            for (int i = 0; i < rows; i++)
            {
                String input = scan.getWord();
                if (input.contains("@"))
                {
                    start = new Point(i, input.indexOf("@"));
                }
                map[i] = input.toCharArray();
                Arrays.fill(distances[i], -1);
            }
            maps.add(map);
            expand(0);
            int steps = Integer.MAX_VALUE;
            ArrayDeque<Point> queue = new ArrayDeque<Point>();
            queue.add(start);
            distances[start.x][start.y] = 0;
            while(!queue.isEmpty())
            {
                Point remove = queue.removeFirst();
                int x = remove.x, y = remove.y;
                int dist = distances[x][y] + 1;
                if(x == 0 || y == 0 || x == rows - 1 || y == cols - 1)
                {
                    steps = Math.min(dist, steps);
                }
                char[][] currentMap = maps.get(Math.min(dist, maps.size() - 1));
                if ((x - 1 >= 0) && (currentMap[x - 1][y] == '.') && (distances[x - 1][y] == -1))
                {
                    distances[x - 1][y] = dist;
                    queue.add(new Point(x - 1, y));
                }
                if ((x + 1 < rows) && (currentMap[x + 1][y] == '.') && (distances[x + 1][y] == -1))
                {
                    distances[x + 1][y] = dist;
                    queue.add(new Point(x + 1, y));
                }
                if ((y - 1 >= 0) && (currentMap[x][y - 1] == '.') && (distances[x][y - 1] == -1))
                {
                    distances[x][y - 1] = dist;
                    queue.add(new Point(x, y - 1));
                }
                if ((y + 1 < cols) && (currentMap[x][y + 1] == '.') && (distances[x][y + 1] == -1))
                {
                    distances[x][y + 1] = dist;
                    queue.add(new Point(x, y + 1));
                }
            }
            System.out.println(steps == Integer.MAX_VALUE? "IMPOSSIBLE" : steps);
        }
    }

    public static void expand(int index)
    {
        char[][] current = maps.get(index);
        char[][] copy = new char[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int x = 0; x < cols; x++)
            {
                copy[i][x] = current[i][x];
            }
        }
        for (int i = 0; i < rows; i++)
        {
            for (int x = 0; x < cols; x++)
            {
                if (current[i][x] == '*')
                {
                    if (i - 1 >= 0 && current[i - 1][x] == '.')
                    {
                        copy[i - 1][x] = '*';
                    }
                    if (i + 1 < rows && current[i + 1][x] == '.')
                    {
                        copy[i + 1][x] = '*';
                    }
                    if (x - 1 >= 0 && current[i][x - 1] == '.')
                    {
                        copy[i][x - 1] = '*';
                    }
                    if (x + 1 < cols && current[i][x + 1] == '.')
                    {
                        copy[i][x + 1] = '*';
                    }
                }
            }
        }
        boolean keepExpanding = false;
        check:
        for(int i = 0; i < rows; i++)
        {
            for(int x = 0; x < cols; x++)
            {
                if(copy[i][x] == '*')
                {
                    if (i - 1 >= 0 && current[i - 1][x] == '.')
                    {
                        keepExpanding = true;
                        break check;
                    }
                    if (i + 1 < rows && current[i + 1][x] == '.')
                    {
                        keepExpanding = true;
                        break check;
                    }
                    if (x - 1 >= 0 && current[i][x - 1] == '.')
                    {
                        keepExpanding = true;
                        break check;
                    }
                    if (x + 1 < cols && current[i][x + 1] == '.')
                    {
                        keepExpanding = true;
                        break check;
                    }
                }
            }
        }
        maps.add(copy);
        if (keepExpanding)
            expand(index + 1);
    }
}