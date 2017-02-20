public class npuzzle
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        char[][] should = new char[4][4];
        char[][] input = new char[4][4];
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                should[i][j] = (char)(65 + (i * 4) + j);
            }
            input[i] = scan.getWord().toCharArray();
        }
        int dist = 0;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(should[i][j] != input[i][j])
                {
                    dist += find(input, should[i][j], i, j);
                }
            }
        }
        System.out.println(dist);
        scan.close();
    }

    public static int find(char[][] input , char should, int i, int j)
    {
        for(int x = 0; x < 4; x++)
        {
            for(int y = 0; y < 4; y++)
            {
                if(input[x][y] == should)
                {
                    return Math.abs(i - x) + Math.abs(j - y);
                }
            }
        }
        return 0;
    }
}
