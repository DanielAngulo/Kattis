public class encodedmessage
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int cases = scan.getInt();
        while(cases-- > 0)
        {
            char[] input = scan.getWord().toCharArray();
            int size = input.length;
            int sqrt = (int)Math.sqrt(size);
            StringBuilder result = new StringBuilder("");
            for(int i = sqrt - 1; i >= 0; i--)
            {
                StringBuilder temp = new StringBuilder("");
                for(int x = 0; x < sqrt; x++)
                {
                    temp.append(input[(i + (x * sqrt))]);
                }
                result.append(temp);
            }
            scan.println(result);
        }
        scan.close();
    }
}
