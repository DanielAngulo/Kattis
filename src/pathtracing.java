import java.util.ArrayList;
import java.util.Scanner;
public class pathtracing {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> directions = new ArrayList<String>();
		while(scan.hasNext())
			directions.add(scan.next());
		ArrayList<String> board = new ArrayList<String>();
		for(int i = 0; i < 10; i++)
			board.add(" ");
		board.set(0, "S");
		int currentH = 0;
		int currentW = 0;
		for(String str : directions){
			if(str.equals("up")){
				currentH--;
				if(currentH == -1){
					board.add(0, newString(board.get(1).length()));
					currentH = 0;
				}
			}
			else if(str.equals("down")){
				currentH++;
				if(currentH == board.size())
					board.add(newString(board.get(0).length()));
			}
			else if(str.equals("left")){
				currentW--;
				if(currentW == -1){
					currentW = 0;
					addSpace(board, true);
				}
			}
			else{
				currentW++;
				if(currentW >= board.get(0).length())
					addSpace(board, false);
			}
			board.set(currentH, setStar(board.get(currentH).toCharArray(), currentW));
		}
		if(currentH >= board.size())
			currentH = board.size() - 1;
		if(currentW >= board.get(currentH).length())
			currentW = board.get(currentH).length() - 1;
		char[] temp = board.get(currentH).toCharArray();
		temp[currentW] = 'E';
		board.set(currentH, new String(temp));
		trimBoard(board);
		printBoard(board);
	}

	private static String newString(int length) {
		String str = "";
		for(int i = 0; i < length; i++)
			str += " ";
		return str;
	}

	private static void addSpace(ArrayList<String> board, boolean start) {
		int size = board.size();
		if(start)
			for(int i = 0; i < size; i++)
				board.set(i, " " + board.get(i));
		else
			for(int i = 0; i < size; i++)
				board.set(i, board.get(i) + " ");
	}

	private static String setStar(char[] string, int currentW) {
		if(string[currentW] != 'S')
			string[currentW] = '*';
		return new String(string);
	}
	
	private static void trimBoard(ArrayList<String> board) {
		for(int i = 0; i < board.size(); i++){
			if(board.get(i).trim().equals("")){
				board.remove(i);
				i--;
			}
		}
		int length = board.get(0).length();
		for(int i = 0; i < length; i++){
			String str = "";
			for(String x : board)
				str += x.charAt(i);
			if(str.trim().length() == 0){
				for(int x = 0; x < board.size(); x++)
					board.set(x, board.get(x).substring(0, i));
				break;
			}
		}
	}
	
	private static void printBoard(ArrayList<String> board) {
		int length = board.get(0).length() + 2;
		String border = "";
		for(int i = 0; i < length; i++)
			border += "#";
		System.out.println(border);
		for(String str : board)
			System.out.println("#" + str + "#");
		System.out.println(border);
	}
}
