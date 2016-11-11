import java.util.ArrayList;
import java.util.Arrays;
public class dungeon
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        while(true)
        {
            int levels = scan.getInt(), rows = scan.getInt(), columns = scan.getInt();
            if(levels + rows + columns == 0)
                break;
            char[][][] map = new char[levels][rows][columns];
            int[][][] distances = new int[levels][rows][columns];
            ThreeDimensionalPoint start = new ThreeDimensionalPoint(-1, -1, -1), end = new ThreeDimensionalPoint(-1, -1, -1);
            for(int i = 0; i < levels; i++)
            {
                for(int j = 0; j < rows; j++)
                {
                    String input = scan.getWord();
                    if(input.contains("S"))
                    {
                        int index = input.indexOf("S");
                        start = new ThreeDimensionalPoint(i, j, index);
                    }
                    if(input.contains("E"))
                    {
                        int index = input.indexOf("E");
                        end = new ThreeDimensionalPoint(i, j, index);
                        input = input.substring(0, index) + "." + input.substring(index + 1);
                    }
                    map[i][j] = input.toCharArray();
                    Arrays.fill(distances[i][j], - 1);
                }
            }
            ArrayList<ThreeDimensionalPoint> queue = new ArrayList<ThreeDimensionalPoint>();
            queue.add(start);
            distances[start.z][start.x][start.y] = 0;
            while(!queue.isEmpty())
            {
                ThreeDimensionalPoint current = queue.remove(0);
                int x = current.x, y = current.y, z = current.z;
                int newDist = distances[z][x][y] + 1;
                if(x - 1 >= 0 && map[z][x - 1][y] == '.' && distances[z][x - 1][y] == -1)
                {
                    distances[z][x - 1][y] = newDist;
                    queue.add(new ThreeDimensionalPoint(z, x - 1, y));
                }
                if(x + 1 < rows && map[z][x + 1][y] == '.' && distances[z][x + 1][y] == -1)
                {
                    distances[z][x + 1][y] = newDist;
                    queue.add(new ThreeDimensionalPoint(z, x + 1, y));
                }
                if(y - 1 >= 0 && map[z][x][y - 1] == '.' && distances[z][x][y - 1] == -1)
                {
                    distances[z][x][y - 1] = newDist;
                    queue.add(new ThreeDimensionalPoint(z, x, y - 1));
                }
                if(y + 1 < columns && map[z][x][y + 1] == '.' && distances[z][x][y + 1] == -1)
                {
                    distances[z][x][y + 1] = newDist;
                    queue.add(new ThreeDimensionalPoint(z, x, y + 1));
                }
                if(z - 1 >= 0 && map[z - 1][x][y] == '.' && distances[z - 1][x][y] == - 1)
                {
                    distances[z - 1][x][y] = newDist;
                    queue.add(new ThreeDimensionalPoint(z - 1, x, y));
                }
                if(z + 1 < levels && map[z + 1][x][y] == '.' && distances[z + 1][x][y] == - 1)
                {
                    distances[z + 1][x][y] = newDist;
                    queue.add(new ThreeDimensionalPoint(z + 1, x, y));
                }
            }
            int last = distances[end.z][end.x][end.y];
            System.out.println(last == -1? "Trapped!": "Escaped in " + last + " minute(s).");
        }
        scan.close();
    }
}

class ThreeDimensionalPoint
{
    int x, y, z;

    public ThreeDimensionalPoint(int z, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}