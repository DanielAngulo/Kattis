public class battlesimulation
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        char[] input = (scan.getWord() + "ZZ").toCharArray();
        StringBuilder result = new StringBuilder("");
        int iterations = input.length - 2;
        for(int i = 0; i < iterations; i++)
        {
            char first = input[i];
            char second = input[i + 1];
            char third = input[i + 2];
            if(first == 'R')
            {
                if((second == 'B' && third == 'L') || (second == 'L' && third == 'B'))
                {
                    result.append("C");
                    i += 2;
                }
                else
                    result.append("S");
            }
            else if(first == 'B')
            {
                if((second == 'R' && third == 'L') || (second == 'L' && third == 'R'))
                {
                    result.append("C");
                    i += 2;
                }
                else
                    result.append("K");
            }
            else
            {
                if((second == 'R' && third == 'B') || (second == 'B' && third == 'R'))
                {
                    result.append("C");
                    i += 2;
                }
                else
                    result.append("H");
            }
        }
        scan.println(result);
        scan.close();
    }
}
