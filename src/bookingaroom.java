import java.util.ArrayList;
import java.util.Scanner;
public class bookingaroom {
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int n = scan.nextInt();
		for(int i = 1; i <= r; i++)
			list.add(i + "");
		for(int i = 0; i < n; i++)
			list.remove(getIndex(scan.nextInt() + ""));
		if(list.size() == 0)
			System.out.print("too late");
		else
			System.out.println(list.get(0));
	}

	private static int getIndex(String string) {
		for(int i = 0; i < list.size(); i++)
			if(list.get(i).equals(string))
				return i;
		return 0;
	}
}
