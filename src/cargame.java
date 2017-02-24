import java.util.Scanner;
public class cargame {

    public static boolean check(String word, String plate)
    {
        int indices[] = {-1, -1, -1};
        indices[0] = word.indexOf(plate.charAt(0));
        if(indices[0] == -1)
            return false;
        indices[1] = word.indexOf(plate.charAt(1), indices[0] + 1);
        if(indices[1] == -1)
            return false;
        indices[2] = word.indexOf(plate.charAt(2), indices[1] + 1);
        if(indices[2] == -1)
            return false;
        return true;
    }


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int wordNum = scan.nextInt();
        int plateNum = scan.nextInt();
        String[] dictionary = new String[wordNum];
        for(int i = 0; i < wordNum; i++)
            dictionary[i] = scan.next();
        for(int i = 0; i < plateNum; i++)
        {
            String plate = scan.next().toLowerCase();
            boolean word = false;
            for(int j = 0; j < wordNum; j++)
            {
                if(check(dictionary[j], plate))
                {
                    System.out.println(dictionary[j]);
                    word = true;
                    break;
                }
            }
            if(!word)
                System.out.println("No valid word");
        }
    }

}