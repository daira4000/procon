import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		long a[] = new long[n];
		long l[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong();
			l[i] = (a[i] - (i + 1));
		}

		Arrays.sort(l);
		long b = l[l.length / 2];

		long sum = 0;
		for (int i = 0; i < n; i++) {
			long abs = Math.abs(a[i] - (b + (i + 1)));
			sum += abs;
		}
		System.out.println(sum);
	}
}
