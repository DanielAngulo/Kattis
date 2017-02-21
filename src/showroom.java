import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class showroom
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
		Scanner scan = new Scanner(System.in);
		int height = scan.nextInt(), width = scan.nextInt();
		char[][] map = new char[height][width];
		int[][] distances = new int[height][width];
		for(int i = 0; i < height; i++)
		{
			map[i] = scan.next().toCharArray();
			Arrays.fill(distances[i], -1);
		}
		Point start = new Point(scan.nextInt() - 1, scan.nextInt() - 1);
        ArrayList<Point> ends = new ArrayList<Point>();
        for(int i = 0; i < width; i++)
        {
            if(map[0][i] == 'D')
                ends.add(new Point(0, i));
            if(map[map.length-1][i] == 'D')
                ends.add(new Point(map.length - 1, i));
        }
        for(int i = 0; i < height; i++)
        {
            if(map[i][0] == 'D')
                ends.add(new Point(i, 0));
            if(map[i][map[0].length - 1] == 'D')
                ends.add(new Point(i, map[0].length-1));
        }
		distances[start.x][start.y] = 1;
		ArrayDeque<Point> queue = new ArrayDeque<Point>();
		queue.add(start);
		boolean found = false;
        int[] di = new int[] {0,0,1,-1};
        int[] dj = new int[] {1,-1,0,0};
        int minDistance = -1;
        while(!queue.isEmpty())
        {
            Point current = queue.poll();
            int at_i = current.x;
            int at_j = current.y;
            check:
            for(Point car : ends)
            {
                if(at_i == car.x && at_j == car.y)
                {
                    if(!found)
                    {
                        minDistance = distances[car.x][car.y];
                        found = true;
                        break check;
                    }
                    found = true;
                }
            }
            if(!found || (found && distances[at_i][at_j] <= minDistance))
            for(int k = 0; k < 4; k ++)
            {
                int next_i = at_i + di[k];
                int next_j = at_j + dj[k];
                if(next_i >= height || next_i < 0 || next_j >= width || next_j < 0 || distances[next_i][next_j] != -1 || map[next_i][next_j] == '#')
                    continue;
                if(map[next_i][next_j] == 'c')
                {
                    distances[next_i][next_j] = distances[at_i][at_j] + 1;
                    queue.add(new Point(next_i, next_j));
                }
                else
                {
                    distances[next_i][next_j] = distances[at_i][at_j];
                    queue.addFirst(new Point(next_i, next_j));
                }
            }
        }
		System.out.println(minDistance);
	}
}