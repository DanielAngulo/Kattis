public class oktalni
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        String input = scan.getWord();
        while(input.length() % 3 != 0)
        {
            input = "0" + input;
        }
        int length = input.length()/3;
        String output = "";
        for(int i = 0; i < length; i++)
        {
            output += ("" + Integer.parseInt(input.substring(i * 3, (i * 3) + 3), 2));
        }
        scan.println(output);
        scan.close();
    }
}
