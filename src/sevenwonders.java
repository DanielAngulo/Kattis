public class sevenwonders
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        String input = scan.getWord();
        int[] amount = new int[3];
        String indices = "TCG";
        for(int i = 0; i < input.length(); i++)
            amount[indices.indexOf(input.charAt(i))]++;
        int count = 0;
        for(int i : amount)
        {
            count += Math.pow(i, 2);
        }
        while(amount[0] > 0 && amount[1] > 0 && amount[2] > 0)
        {
            amount[0]--;
            amount[1]--;
            amount[2]--;
            count += 7;
        }
        System.out.println(count);
        scan.close();
    }
}
