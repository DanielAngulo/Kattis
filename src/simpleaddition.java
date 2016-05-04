import java.math.BigInteger;
import java.util.Scanner;
public class simpleaddition {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(new BigInteger(scan.next()).add(new BigInteger(scan.next())));
	}
}
