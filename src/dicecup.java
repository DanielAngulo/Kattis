public class dicecup
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int max = Integer.MIN_VALUE;
        int[] die = {scan.getInt(), scan.getInt()};
        int[] possible = new int[die[0] + die[1]];
        for(int i = 1; i < die[0]; i++)
        {
            for(int j = 1; j < die[1]; j++)
                possible[i + j]++;
        }
        for(int i : possible)
            max = Math.max(max, i);
        for(int i = 1; i < possible.length; i++)
        {
            if(possible[i] == max)
                scan.println(i + 1);
        }
        scan.close();
    }
}
