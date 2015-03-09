package misc;

import java.util.LinkedList;
import java.util.ListIterator;

/*
 * Finding a fibonacci number at the desired location using LinkedList for infinite precision 
 */
public class LinkedListAddition {

	public static void main(String[] args) {
		String firstNo = "0";
		String SecondNo = "1";
		String currentPosition = "2";
		String desiredPosition = "10000";
		while (!desiredPosition.equalsIgnoreCase(currentPosition)) {
			String tempno = SecondNo;
			SecondNo = sum(SecondNo, firstNo);
			firstNo = tempno;
			currentPosition = sum(currentPosition, "1");
			System.out.println("Position=>" + currentPosition);
			System.out.println("Number=>" + SecondNo);
		}
		System.out.println("The fibonacci number at position "
				+ desiredPosition + " is " + SecondNo);
	}

	public static String sum(String num1, String num2) {
		String num3 = "";
		int carry = 0;
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		StringBuffer num1Buff = new StringBuffer(num1);
		num1 = num1Buff.reverse().toString();
		for (char ch : num1.toCharArray()) {
			ll1.add(Integer.parseInt(String.valueOf(ch)));
		}
		StringBuffer num2Buff = new StringBuffer(num2);
		num2 = num2Buff.reverse().toString();
		for (char ch : num2.toCharArray()) {
			ll2.add(Integer.parseInt(String.valueOf(ch)));
		}

		ListIterator<Integer> ll1Itr = ll1.listIterator();
		ListIterator<Integer> ll2Itr = ll2.listIterator();
		LinkedList<Integer> llSum = new LinkedList<Integer>();
		while (ll1Itr.hasNext() || ll2Itr.hasNext()) {
			int firstDigit = 0;
			if (ll1Itr.hasNext()) {
				firstDigit = ll1Itr.next();
			}
			int secondDigit = 0;
			if (ll2Itr.hasNext()) {
				secondDigit = ll2Itr.next();
			}
			int sumDigit = firstDigit + secondDigit + carry;
			if (sumDigit > 9) {
				carry = sumDigit / 10;
				sumDigit = sumDigit % 10;
			} else {
				carry = 0;
			}
			llSum.add(sumDigit);
		}
		if (carry > 0) {
			llSum.add(carry);
		}
		ListIterator<Integer> llsumIterator = llSum.listIterator();
		StringBuilder sb = new StringBuilder();
		while (llsumIterator.hasNext()) {
			sb.append(llsumIterator.next());
		}
		num3 = sb.reverse().toString();
		return num3;
	}
}