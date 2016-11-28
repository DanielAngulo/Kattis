public class countingstars
{
    static char[][] map;
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int current = 1;
        while(scan.hasMoreTokens())
        {
            int height = scan.getInt(), width = scan.getInt();
            map = new char[height][width];
            for(int i = 0; i < height; i++)
                map[i] = scan.getWord().toCharArray();
            int count = 0;
            for(int i = 0; i < height; i++)
            {
                for(int x = 0; x < width; x++)
                {
                    if(map[i][x] == '-')
                    {
                        count++;
                        getStar(i, x);
                    }
                }
            }
            System.out.println("Case " + current + ": " + count);
            current++;
        }
        scan.close();
    }

    public static void getStar(int x, int y)
    {
        if(x < 0 || x >= map.length || y < 0 || y >= map[0].length || map[x][y] != '-')
            return;
        map[x][y] = '#';
        getStar(x + 1, y);
        getStar(x - 1, y);
        getStar(x, y + 1);
        getStar(x, y - 1);
    }
}