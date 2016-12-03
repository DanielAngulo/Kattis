public class humancannonball2
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        int cases = scan.getInt();
        while(cases-- > 0)
        {
            double velocity = scan.getDouble();
            double radian = Math.toRadians(scan.getDouble());
            double x1 = scan.getDouble();
            double h1 = scan.getDouble(), h2 = scan.getDouble();
            double xT = x1/(velocity * Math.cos(radian));
            double yT = velocity * xT * (Math.sin(radian)) - (.5 * 9.81 * Math.pow(xT, 2));
            if(yT >= h1 + 1 && yT <=h2 - 1)
                System.out.println("Safe");
            else
                System.out.println("Not Safe");
        }
        scan.close();
    }
}
