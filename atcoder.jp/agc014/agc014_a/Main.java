import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		int ret = solv(a, b, c);
		System.out.println(ret);
	}

	private static int solv(long a, long b, long c) {
		int count = 0;
		if (a == b && b == c) return a % 2 == 0 ? -1 : 0 ;

		while (a % 2 == 0 && b % 2 == 0 && c % 2 == 0) {
			count++;
			long aa = a / 2;
			long bb = b / 2;
			long cc = c / 2;
			a = bb + cc;
			b = aa + cc;
			c = aa + bb;
		}
		return count;
	}
}
