import java.util.*;

public class bard
{
    public static void main(String[] args)
    {
        HashMap<Integer, HashSet<Integer>> villagersAndSongs = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int villagers = scan.nextInt();
        int evenings = scan.nextInt();
        int currentSong = 1;
        for(int i = 0; i < evenings; i++)
        {
            int amount = scan.nextInt();
            int[] villagersPresent = new int[amount];
            for(int j = 0; j < amount; j++)
            {
                villagersPresent[j] = scan.nextInt();
            }
            Arrays.sort(villagersPresent);
            if(villagersPresent[0] == 1)
            {
                for(int x = 1; x < amount; x++)
                {
                    if(!villagersAndSongs.containsKey(villagersPresent[x]))
                    {
                        villagersAndSongs.put(villagersPresent[x], new HashSet<Integer>());
                        villagersAndSongs.get(villagersPresent[x]).add(currentSong);
                    }
                    else
                    {
                        villagersAndSongs.get(villagersPresent[x]).add(currentSong);
                    }
                }
                currentSong++;
            }
            else
            {
                HashSet<Integer> masterSet = new HashSet<>();
                for(int x = 0; x < amount; x++)
                {
                    if(villagersAndSongs.containsKey(villagersPresent[x]))
                        masterSet.addAll(villagersAndSongs.get(villagersPresent[x]));
                }
                for(int x = 0; x < amount; x++)
                {
                    if(villagersAndSongs.containsKey(villagersPresent[x]))
                    {
                        villagersAndSongs.put(villagersPresent[x], new HashSet<>(masterSet));
                    }
                    else
                    {
                        villagersAndSongs.put(villagersPresent[x], new HashSet<>(masterSet));
                    }
                }
            }
        }
        System.out.println(1);
        ArrayList<Integer> print = new ArrayList<>();
        currentSong--;
        for(Map.Entry<Integer, HashSet<Integer>> villager : villagersAndSongs.entrySet())
        {
            if(villager.getValue().size() == currentSong)
            {
                print.add(villager.getKey());
            }
        }
        Collections.sort(print);
        for(int i : print)
            System.out.println(i);
        scan.close();
    }
}
