import java.util.ArrayList;
import java.util.Scanner;
public class peg
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<String>();
        while(scan.hasNextLine())
        {
            String nextLine = scan.nextLine();
            input.add(nextLine);
        }
        char[][] map = new char[input.size()][];
        for(int i = 0; i < input.size(); i++)
            map[i] = input.get(i).toCharArray();
        int legal = 0, height = map.length, width = map[0].length;
        for(int i = 0; i < height; i++)
        {
            for(int x = 0; x < width; x++)
            {
                if(map[i][x] == 'o')
                {
                    if(i - 2 >= 0 && map[i - 2][x] == '.' && map[i - 1][x] == 'o')
                        legal++;
                    if(i + 2 < height && map[i + 2][x] == '.' && map[i + 1][x] == 'o')
                        legal++;
                    if(x - 2 >= 0 && map[i][x - 2] == '.' && map[i][x - 1] == 'o')
                        legal++;
                    if(x + 2 < width && map[i][x + 2] == '.' && map[i][x + 1] == 'o')
                        legal++;
                }
            }
        }
        System.out.println(legal);
    }
}
