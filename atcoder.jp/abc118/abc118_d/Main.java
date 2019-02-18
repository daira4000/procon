import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] ms = new int[] { 2, 5, 5, 4, 5, 6, 3, 7, 6 };

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();
		int[] A = new int[M];
		for (int i = 0; i < M; i++) {
			A[i] = in.nextInt();
		}

		Arrays.parallelSort(A);

		String[] dp = new String[N + 1];
		dp[0] = "";

		for (int n = 0; n < N; n++) {
			if (dp[n] == null) {
				continue;
			}
			for (int i = A.length - 1; 0 <= i; i--) {
				int m = ms[A[i] - 1];
				int use = n + m;
				if (N < use) {
					continue;
				}
				String value = A[i] + dp[n];
				if (check(value, dp[use])) {
					dp[use] = value;
				}
			}
		}
		System.out.println(dp[N]);
	}

	private static boolean check(String a, String b) {
		if (b == null || a.length() > b.length()) {
			return true;
		}
		if (b.length() > a.length()) {
			return false;
		}
		return a.compareTo(b) > 0;
	}
}
