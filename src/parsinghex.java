import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class parsinghex {
	static String hex = "0123456789ABCDEFabcdef";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String read = scan.next() + "Z";
			ArrayList<String> parts = new ArrayList<String>();
			char[] array = read.toCharArray();
			for(int i = 0; i < array.length; i++){
				if(array[i] == '0'){
					if(array[i + 1] == 'x' || array[i + 1] == 'X'){
						String add = "0" + array[i + 1];
						int index = 2;
						boolean keep = true;
						while(keep){
							if(hex.indexOf(array[i + index] + "") >= 0)
								add += array[i + index];
							else{
								parts.add(add.trim());
								i += index;
								keep = false;
							}
							index++;
						}
					}
				}
			}
			for(String str : parts){
				if(!str.isEmpty() && str.length() > 2){
					System.out.println(str + " " + Long.parseLong(str.substring(2), 16));
				}
			}
		}
	}
}