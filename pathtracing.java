import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class pathtracing {
	static ArrayList<String> directions = new ArrayList<String>();
	static String[] instructions;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> map = new ArrayList<String>();
	public static void main(String[] args) {
		while(scan.hasNext()){
			String str = scan.next();
			if(str.equals("stop"))
				break;
			directions.add(str);
		}
		/*String[] which = {"up", "left", "down", "right"};
		for(int i = 0; i < 1234; i++){
			directions.add(which[getRandom(0, 4)]);
		}
		for(int i = 0; i < directions.size() - 1; i++){
			String first = directions.get(i);
			String second = directions.get(i + 1);
			if(first.equals("up") && second.equals("down")){
				directions.remove(i + 1);
				i--;
			}
			else if(first.equals("down") && second.equals("up")){
				directions.remove(i + 1);
				i--;
			}
			else if(first.equals("left") && second.equals("right")){
				directions.remove(i + 1);
				i--;
			}
			else if(first.equals("right") && second.equals("left")){
				directions.remove(i + 1);
				i--;
			}
		}
		System.out.println(directions);*/
		instructions = directions.toArray(new String[directions.size()]);
		int h = 0;
		int w = 0;
		int width = getWidth() + 1;
		setMap(width, getWidth() + 1);
		map.set(0, "S" + setSpace(width - 1));
		for(String follow: instructions){
			if(follow.equals("up")){
				h--;
				if(h < 0){
					map.add(0, map.get(1).replaceAll("[^ ]", " "));
					h++;
				}
			}
			else if(follow.equals("down")){
				h++;
				if(h > map.size()){
					map.add(setSpace(width));
				}
			}
			else if(follow.equals("left")){
				w--;
				if(w < 0){
					fixLeft();
					w++;
				}
			}
			else if(follow.equals("right")){
                w++;
                if(w > map.get(h).length()){
                    fixRight();
                }
            }
			if(h >= map.size())
				map.add(map.get(0).replaceAll("[^ ]", " "));
			if(w >= map.get(h).length())
				fixRight();
			String str = map.get(h);
			str = set(str, w);
			map.set(h, str);
		}
		if(h >= map.size())
			h = map.size() - 1;
		if(w >= map.get(h).length())
			w = map.get(h).length() - 1;
		String str = map.get(h);
		char[] temp = str.toCharArray();
		temp[w] = 'E';
		map.set(h, new String(temp));
		printFinal();
	}
	
	private static int getRandom(int min, int max) {
		return (int)(Math.random() * (max - min) + min);
	}

	public static String set(String str, int w){
		char[] array = str.toCharArray();
		if(array[w] != 'S')
			array[w] = '*';
		return new String(array);
	}
	
	public static void fixLeft(){
		for(int i = 0; i < map.size(); i++){
			map.set(i, " " + map.get(i));
		}
	}
	
	public static void fixRight(){
		for(int i = 0; i < map.size(); i++){
			map.set(i, map.get(i) + " ");
		}
	}
	
	public static int getHeight(){
		int[] absolute = new int[directions.size() - 1];
		if(directions.get(0).equals("up"))
			absolute[0] = 1;
		else if(directions.get(1).equals("down"))
			absolute[0] = -1;
		for(int i = 1; i < absolute.length; i++){
			String str = directions.get(i);
			if(str.equals("up")){
				absolute[i] = absolute[i - 1] + 1;
			}
			else if(str.equals("down"))
				absolute[i] = absolute[i - 1] - 1;
		}
		Arrays.sort(absolute);
		return Math.abs(absolute[0]) + absolute[absolute.length - 1];
	}
	
	public static int getWidth(){
		int count = 0;
		for(String str : directions)
			if(str.equals("left") || str.equals("right"))
				count++;
		return count;
	}
	
	public static void setMap(int h, int w){
		String str = "";
		for(int i = 0; i <= w; i++)
			str += " ";
		for(int i = 0; i < h; i++)
			map.add(str);
	}
	
	public static String setSpace(int w){
		String str = "";
		for(int i = 0; i <= w; i++)
			str += " ";
		return str;
	}
	
	public static void printFinal(){
		eraseBlank();
		String border = "";
		for(int i = 0; i < map.get(0).length() + 2; i++)
			border += "#";
		System.out.println(border);
		for(String str : map)
			System.out.println("#" + str + "#");
		System.out.println(border);
	}
	
	public static void eraseBlank(){
		for(int i = 0; i < map.size(); i++){
			if(map.get(i).trim().equals("")){
				map.remove(i);
				i--;
			}
		}
		for(int i = 0; i < map.get(0).length(); i++){
			String str = "";
			for(String x : map){
				str += x.charAt(i);
			}
			if(str.trim().equals("")){
				for(int x = 0; x < map.size(); x++){
					String current = map.get(x);
					current = current.substring(0, i) + current.substring(i + 1);
					map.set(x, current);
				}
				i--;
			}
		}
	}
}