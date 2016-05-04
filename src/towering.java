import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class towering {
	static ArrayList<Integer> list;
	static ArrayList<Integer[]> perms = new ArrayList<Integer[]>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		list = new ArrayList<Integer>(Arrays.asList(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
		int box1 = scan.nextInt();
		int box2 = scan.nextInt();
		permutation(list);
		for(Integer[] arr : perms){
			if(sum1(arr) == box1){
				if(sum2(arr) == box2){
					print(arr);
					break;
				}
			}
		}
	}

	private static void print(Integer[] arr) {
		Integer[] first = {arr[0], arr[1], arr[2]};
		Arrays.sort(first);
		Integer[] second = {arr[3], arr[4], arr[5]};
		Arrays.sort(second);
		System.out.println(first[2] + " " + first[1] + " " + first[0] + " " + second[2] + " " + second[1] + " " + second[0]);
	}

	private static int sum2(Integer[] arr) {
		int sum = 0;
		for(int i = 3; i < 6; i++)
			sum += arr[i];
		return sum;
	}

	private static int sum1(Integer[] arr) {
		int sum = 0;
		for(int i = 0; i < 3; i++)
			sum += arr[i];
		return sum;
	}

	public static void permutation(ArrayList<Integer> list) { 
		ArrayList<Integer> other = new ArrayList<Integer>();
		for(int i : list)
			other.add(i);
	    permutation(new ArrayList<Integer>(), other); 
	}
	
	private static void permutation(ArrayList<Integer> prefix, ArrayList<Integer> str) {
	    int n = str.size();
	    if (n == 0){
	    	perms.add(prefix.toArray(new Integer[prefix.size()]));
	    	return;
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(add(prefix, str.get(i)), add(getRange(str, 0, i), getRange(str, i + 1, n)));
	    }
	}
	
	private static ArrayList<Integer> add(ArrayList<Integer> range, ArrayList<Integer> range2) {
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		for(int i : range)
			toReturn.add(i);
		for(int i : range2)
			toReturn.add(i);
		return toReturn;
	}

	public static ArrayList<Integer> add(ArrayList<Integer> tempList, Integer num){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i : tempList)
			temp.add(i);
		temp.add(num);
		return temp;
	}
	
	public static ArrayList<Integer> getRange(ArrayList<Integer> temp, int start, int end){
		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		for(int i = start; i < end; i++)
			toReturn.add(temp.get(i));
		return toReturn;
	}
}
