import java.util.Scanner;

public class chopin {

	public static void main(String[] args) {
		String[] notes = {"A", "A#/Bb", "B", "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab"};
		Scanner scan = new Scanner(System.in);
		int current = 1;
		while(scan.hasNextLine()){
			String[] array = scan.nextLine().split(" ");
			boolean keep = true;
			if(array[0].length() == 1){
				System.out.println("Case " + current +": UNIQUE");
			}
			else{
				while(keep){
					String searching = array[0];
					for(String str : notes){
						String[] temp = str.split("/");
						if(temp.length > 1){
							if(temp[0].equals(searching)){
								System.out.println("Case " + current + ": " + temp[1] + " " + array[1]);
								keep = false;
							}
							else if(temp[1].equals(searching)){
								System.out.println("Case " + current + ": " + temp[0] + " " + array[1]);
								keep = false;
							}
						}
					}
				}
			}
			current++;
		}
	}
}