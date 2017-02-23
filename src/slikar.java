import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class slikar
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
        rows = scan.getInt();
        cols = scan.getInt();
        char[][] map = new char[rows][cols];
        Point start = new Point(-1, -1);
        Point end = new Point(-1, -1);
        int[][] distances = new int[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            String input = scan.getWord();
            if(input.contains("S"))
            {
                start = new Point(i, input.indexOf("S"));
            }
            if(input.contains("D"))
            {
                end = new Point(i, input.indexOf("D"));
            }
            map[i] = input.toCharArray();
            Arrays.fill(distances[i], -1);
        }
        maps.add(map);
        expand(0);
        for(int i = 0; i < maps.size(); i++)
        {
            maps.get(i)[end.x][end.y] = '.';
        }
        distances[start.x][start.y] = 0;
        ArrayDeque<Point> queue = new ArrayDeque<Point>();
        queue.add(start);
        while(!queue.isEmpty())
        {
            Point remove = queue.removeFirst();
            int x = remove.x, y = remove.y;
            int dist = distances[x][y];
            char[][] currentMap = maps.get(Math.min(dist + 1, maps.size() - 1));
            if((x - 1 >= 0) && (currentMap[x - 1][y] == '.') && (distances[x - 1][y] == -1))
            {
                distances[x - 1][y] = dist + 1;
                queue.add(new Point(x - 1, y));
            }
            if((x + 1 < rows) && (currentMap[x + 1][y] == '.') && (distances[x + 1][y] == -1))
            {
                distances[x + 1][y] = dist + 1;
                queue.add(new Point(x + 1, y));
            }
            if((y - 1 >= 0) && (currentMap[x][y - 1] == '.') && (distances[x][y - 1] == -1))
            {
                distances[x][y - 1] = dist + 1;
                queue.add(new Point(x, y - 1));
            }
            if((y + 1 < cols) && (currentMap[x][y + 1] == '.') && (distances[x][y + 1] == -1))
            {
                distances[x][y + 1] = dist + 1;
                queue.add(new Point(x, y + 1));
            }
        }
        System.out.println(distances[end.x][end.y] != -1? distances[end.x][end.y] : "KAKTUS");
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
