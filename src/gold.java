/*
    With a crucial fix by Pedro Contipelli
 */
import java.util.ArrayList;
public class gold
{
    static char[][] map;
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int width = scan.getInt(), height = scan.getInt();
        GoldPoint[][] map = new GoldPoint[height][width];
        int x = 0, y = 0;
        boolean found = false;
        for(int i = 0; i < height; i++)
        {
            String input = scan.getWord();
            char[] array = input.toCharArray();
            for(int j = 0; j < array.length; j++)
                map[i][j] = new GoldPoint(array[j], i, j);
            if(!found)
            {
                if(input.contains("P"))
                {
                    x = i;
                    y = input.indexOf("P");
                    found = true;
                }
            }
        }
        map[x][y].visited = true;
        GoldPoint start = map[x][y];
        ArrayList<GoldPoint> queue = new ArrayList<GoldPoint>();
        queue.add(start);
        int gold = 0;
        while(!queue.isEmpty())
        {
            GoldPoint current = queue.remove(0);
            x = current.x;
            y = current.y;
            if(current.content == 'G')
                gold++;
            boolean move = !(map[x + 1][y].content == 'T' || map[x - 1][y].content == 'T' || map[x][y + 1].content == 'T' || map[x][y - 1].content == 'T');
            if(move)
            {
                map[x][y].visited = true;
                if(!map[x + 1][y].visited)
                {
                    map[x + 1][y].visited = true;
                    queue.add(map[x + 1][y]);
                }
                if(!map[x - 1][y].visited)
                {
                    map[x - 1][y].visited = true;
                    queue.add(map[x - 1][y]);
                }
                if(!map[x][y + 1].visited)
                {
                    map[x][y + 1].visited = true;
                    queue.add(map[x][y + 1]);
                }
                if(!map[x][y - 1].visited)
                {
                    map[x][y - 1].visited = true;
                    queue.add(map[x][y - 1]);
                }
            }
        }
        System.out.println(gold);
        scan.close();
    }
}

class GoldPoint
{
    char content;
    boolean visited = false;
    int x, y;

    public GoldPoint(char c, int x, int y)
    {
        content = c;
        if(c == '#')
            visited = true;
        this.x = x;
        this.y = y;
    }
}