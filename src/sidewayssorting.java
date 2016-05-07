import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class sidewayssorting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			int amount = scan.nextInt();
			int size = scan.nextInt();
			if(amount == 0)
				break;
			else{
				ArrayList<String> list = new ArrayList<String>();
				for(int i = 0; i < amount; i++)
					list.add(scan.next());
				ArrayList<String> actual = new ArrayList<String>();
				for(int i = 0; i < size; i++){
					String str = "";
					for(int x = 0; x < amount; x++)
						str += list.get(x).charAt(i);
					actual.add(str);
				}
				Collections.sort(actual, String.CASE_INSENSITIVE_ORDER);
				for(int i = 0; i < amount; i++){
					String str = "";
					for(int x = 0; x < size; x++)
						str += actual.get(x).charAt(i);
					System.out.println(str);
				}
				System.out.println();
			}
		}
	}
}