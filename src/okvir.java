public class okvir
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        int height = scan.getInt(), width = scan.getInt();
        int up = scan.getInt(), left = scan.getInt(), right = scan.getInt(), down = scan.getInt();
        int current = 0;
        char[] use = {'#', '.'};
        int row = 0;
        for(int i = 0; i < up; i++)
        {
            current = i % 2;
            StringBuilder print = new StringBuilder("");
            for(int j = 0; j < left + right + width; j++)
            {
                print.append(use[current]);
                current = (current + 1) % 2;
            }
            scan.println(print.toString());
            row++;
        }
        for(int i = 0; i < height; i++)
        {
            current = row % 2;
            StringBuilder print = new StringBuilder("");
            for(int j = 0; j < left; j++)
            {
                print.append(use[current]);
                current = (current + 1) % 2;
            }
            print.append(scan.getWord());
            current += width;
            current %= 2;
            for(int j = 0; j < right; j++)
            {
                print.append(use[current]);
                current = (current + 1) % 2;
            }
            scan.println(print.toString());
            row++;
        }
        for(int i = 0; i < down; i++)
        {
            current = row % 2;
            StringBuilder print = new StringBuilder("");
            for(int j = 0; j < left + right + width; j++)
            {
                print.append(use[current]);
                current = (current + 1) % 2;
            }
            scan.println(print.toString());
            row++;
        }
        scan.close();
    }
}
