import java.util.ArrayDeque;
import java.util.Arrays;

public class tenkindsofpeople
{
	/*
	 * don't vandalize this, you little shits
	 */
    static class Point
    {
        int x, y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p)
        {
            if(p.x == x && p.y == y)
                return 0;
            return -1;
        }

        public boolean equals(Point p)
        {
            return p.x == x && p.y == y;
        }
    }
    
    static char[][] map;
    static int[][] indices;
    static int height, width;
    static int index = 0;

    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        height = scan.getInt();
        width = scan.getInt();
        map = new char[height][width];
        indices = new int[height][width];
        for(int i = 0; i < height; i++)
        {
            map[i] = scan.getWord().toCharArray();
            Arrays.fill(indices[i], -1);
        }
        for(int i = 0; i < height; i++)
        {
        	for(int x = 0; x < width; x++)
        	{
        		if(indices[i][x] == -1)
        		{
        			expand(i, x, map[i][x]);
        			index++;
        		}
        	}
        }
        int cases = scan.getInt();
        for(int i = 0; i < cases; i++)
        {
            Point start = new Point(scan.getInt() - 1, scan.getInt() - 1);
            Point end = new Point(scan.getInt() - 1, scan.getInt() - 1);
            if(map[start.x][start.y] != map[end.x][end.y])
            {
                System.out.println("neither");
            }
            else
            {
            	if(indices[start.x][start.y] == indices[end.x][end.y])
            		System.out.println(map[start.x][start.y] == '1' ? "decimal" : "binary");
            	else
            		System.out.println("neither");
            }
        }
        scan.close();
    }


    public static void expand(int x, int y, char tile)
    {
        ArrayDeque<Point> queue = new ArrayDeque<Point>();
        indices[x][y]= index;
        queue.add(new Point(x, y));
        while(!queue.isEmpty())
        {
            Point currentPoint = queue.removeFirst();
            x = currentPoint.x;
            y = currentPoint.y;
            if(x - 1 >= 0 && map[x - 1][y] == tile && indices[x - 1][y] ==-1)
            {
                queue.add(new Point(x - 1, y));
                indices[x - 1][y] = index;
            }
            if(x + 1 < height && map[x + 1][y] == tile && indices[x + 1][y] ==-1)
            {
                queue.add(new Point(x + 1, y));
                indices[x + 1][y] = index;
            }
            if(y - 1 >= 0 && map[x][y - 1] == tile && indices[x][y - 1] ==-1)
            {
                queue.add(new Point(x, y - 1));
                indices[x][y - 1] = index;
            }
            if(y + 1 < width && map[x][y + 1] == tile && indices[x][y + 1]==-1)
            {
                queue.add(new Point(x, y + 1));
                indices[x][y + 1] = index;
            }
        }
    }
}