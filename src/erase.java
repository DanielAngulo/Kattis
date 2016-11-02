public class erase
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int n = scan.getInt();
        String first = scan.getWord();
        String after = scan.getWord();
        if(n % 2 == 0)
            System.out.println(after.equals(first)? "Deletion succeeded" : "Deletion failed");
        else
        {
            boolean different = true;
            for(int i = 0; i < first.length(); i++)
            {
                if(first.charAt(i) == after.charAt(i))
                {
                    different = false;
                    i = first.length();
                }
            }
            System.out.println(different? "Deletion succeeded": "Deletion failed");
        }
        scan.close();
    }
}
