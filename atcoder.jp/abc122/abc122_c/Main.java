import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int Q = in.nextInt();
		char[] S = in.next().toCharArray();

		long[] count = new long[N];
		Arrays.fill(count, 0);

		for (int i = 1; i < N; i++) {
			if (S[i - 1] == 'A' && S[i] == 'C') {
				count[i] = count[i - 1] + 1;
			} else {
				count[i] = count[i - 1];
			}
		}

		for (int i = 0; i < Q; i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			System.out.println(count[r - 1] - count[l - 1]);
		}
	}
}
