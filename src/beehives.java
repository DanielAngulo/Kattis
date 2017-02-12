public class beehives
{
    static class Beehive
    {
        double x, y;
        boolean sour = false;

        public Beehive(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        public double distance(Beehive BH)
        {
            return Math.sqrt((Math.pow(x - BH.x, 2) + Math.pow(y - BH.y, 2)));
        }
    }

    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in, System.out);
        while(scan.hasMoreTokens())
        {
            double distance = scan.getDouble();
            int beehives = scan.getInt();
            if(distance == 0 && beehives == 0)  break;
            Beehive[] hives = new Beehive[beehives];
            for(int i = 0; i < beehives; i++)
            {
                hives[i] = new Beehive(scan.getDouble(), scan.getDouble());
            }
            int sour = 0;
            for(int i = 0; i < beehives - 1; i++)
            {
                for(int j = i + 1; j < beehives; j++)
                {
                    if(hives[i].distance(hives[j]) <= distance)
                    {
                        hives[i].sour = true;
                        hives[j].sour = true;
                    }
                }
            }
            for(Beehive bh : hives)
            {
                if(bh.sour)
                {
                    sour++;
                }
            }
            scan.println(sour + " sour, " + (beehives - sour) + " sweet");
        }
        scan.close();
    }
}
