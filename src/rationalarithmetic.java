import java.math.BigInteger;
import java.util.Scanner;

public class rationalarithmetic {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++){
			BigInteger x1 = new BigInteger(scan.nextInt() + "");
			BigInteger y1 = new BigInteger(scan.nextInt() + "");
			String op = scan.next();
			BigInteger x2 = new BigInteger(scan.nextInt() + "");
			BigInteger y2 = new BigInteger(scan.nextInt() + "");
			Fraction result = null;
			if(op.equals("+"))
				result = new Fraction(x1.multiply(y2).add(x2.multiply(y1)), y2.multiply(y1));
			else if(op.equals("-"))
				result = new Fraction(x1.multiply(y2).subtract(x2.multiply(y1)), y2.multiply(y1));
			else if(op.equals("*"))
				result = new Fraction(x1.multiply(x2), y2.multiply(y1));
			else
				result = new Fraction(x1.multiply(y2), x2.multiply(y1));
			System.out.println(result);
		}
		scan.close();
	}
}

class Fraction{
	BigInteger num;
	BigInteger den;
	
	public Fraction(BigInteger bigInteger, BigInteger bigInteger2){
		num = bigInteger;
		den = bigInteger2;
		checkSign();
		reduce();
	}
	
	public void reduce(){
		BigInteger gcf = getGcf();
		num = num.divide(gcf);
		den = den.divide(gcf);
		BigInteger temp = getGcf();
		while(!gcf.equals(temp)){
			gcf = temp;
			temp = getGcf();
		}
		num = num.divide(gcf);
		den = den.divide(gcf);
	}

	private BigInteger getGcf() {
		return num.gcd(den);
	}
	
	public String toString(){
		checkSign();
		return num + " / " + den;
	}

	private void checkSign() {
		if(num.signum() == -1 && den.signum() == -1){
			num = num.multiply(new BigInteger(-1 + ""));
			den = den.multiply(new BigInteger(-1 + ""));
		}
		else if(den.signum() == -1){
			num = num.multiply(new BigInteger(-1 + ""));
			den = den.multiply(new BigInteger(-1 + ""));
		}
	}
}