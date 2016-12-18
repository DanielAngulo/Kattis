public class boundingrobots
{
    public static void main(String[] args)
    {
        Kattio scan = new Kattio(System.in);
        while(true)
        {
            int width = scan.getInt(), height = scan.getInt();
            if(height + width == 0)
                break;
            width--;    height--;
            int instructions = scan.getInt();
            int currentX = 0, currentY = 0;
            int robotX = 0, robotY = 0;
            while(instructions-- > 0)
            {
                char direction = scan.getWord().charAt(0);
                int steps = scan.getInt();
                switch(direction)
                {
                    case('u'):
                    {
                        currentY += steps;
                        robotY += steps;
                        currentY = Math.min(height, currentY);
                        break;
                    }
                    case('d'):
                    {
                        currentY -= steps;
                        robotY -= steps;
                        currentY = Math.max(0, currentY);
                        break;
                    }
                    case('l'):
                    {
                        currentX -= steps;
                        robotX -= steps;
                        currentX = Math.max(0, currentX);
                        break;
                    }
                    case('r'):
                    {
                        currentX += steps;
                        robotX += steps;
                        currentX = Math.min(width, currentX);
                        break;
                    }
                }
            }
            System.out.println("Robot thinks " + robotX + " " + robotY);
            System.out.println("Actually at " + currentX + " " + currentY);
            System.out.println();
        }
        scan.close();
    }
}
