import java.util.Scanner;

public class recipes
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        int current = 0;
        while(cases-- > 0)
        {
            current++;
            int r = scan.nextInt();
            int p = scan.nextInt(), d = scan.nextInt();
            double scale = (d * 1.0)/(p * 1.0);
            String[] names = new String[r];
            double[] weight = new double[r];
            double[] percentage = new double[r];
            for(int i = 0; i < r; i++)
            {
                names[i] = scan.next();
                weight[i] = scan.nextDouble();
                percentage[i] = scan.nextDouble();
            }
            int index = -1;
            for(int i = 0; i < r; i++)
            {
                if(percentage[i] == 100)
                {
                    index = i;
                    i = r;
                }
            }
            double scaledweight = weight[index] * scale;
            for(int i = 0; i < r; i++)
            {
                weight[i] = percentage[i] * scaledweight;
            }
            System.out.println("Recipe # " + current);
            for(int i = 0; i < r; i++)
            {
                System.out.print(names[i] + " ");
                System.out.printf("%.1f", weight[i]/100);
                System.out.println();
            }
            System.out.println("----------------------------------------");
        }
        scan.close();
    }
}
