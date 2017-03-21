public class patuljci
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int sum = 0;
        int[] nums = new int[9];
        for(int i = 0; i < 9; i++)
        {
            nums[i] = scan.getInt();
            sum += nums[i];
        }
        int find = sum - 100;
        find:
        for(int i = 0; i < 8; i++)
        {
            int temp = nums[i];
            for(int x = i + 1; x < 9; x++)
            {
                if(temp + nums[x] == find)
                {
                    for(int y = 0; y < 9; y++)
                    {
                        if(y != i && y != x)
                        {
                            scan.println(nums[y]);
                        }
                    }
                    break find;
                }
            }
        }
        scan.close();
    }
}
