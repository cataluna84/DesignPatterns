package misc;

import java.math.BigInteger;

public class UnderstandingBigInteger {

	public static void main(String[] args) {
		BigInteger bigInteger = new BigInteger(
				"123456789123456789123456789123456789");

		System.out.println(bigInteger);

		System.out.println(bigInteger.byteValue());
		System.out.println(bigInteger.shortValue());
		System.out.println(bigInteger.intValue());

		System.out.println(bigInteger.longValue());
		System.out.println(bigInteger.floatValue());
		System.out.println(bigInteger.doubleValue());
		
		
		System.out.println("Square Root of number: " + sqrt(new BigInteger("256")));
	}

	static BigInteger sqrt(BigInteger n) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		while (b.compareTo(a) >= 0) {
			BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
			if (mid.multiply(mid).compareTo(n) > 0)
				b = mid.subtract(BigInteger.ONE);
			else
				a = mid.add(BigInteger.ONE);
		}
		return a.subtract(BigInteger.ONE);
	}

}