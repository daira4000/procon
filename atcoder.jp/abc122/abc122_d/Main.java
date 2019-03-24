import java.util.Scanner;

public class Main {

	public static long mod = 1000000007;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int[][][][] dp = new int[N + 1][4][4][4];
		dp[0][3][3][3] = 1;

		// AGC,ACG,GAC,AG?C,A?GC
		// A=0, C=1, G=2, T=3
		for (int len = 1; len <= N; len++) {
			for (int c1 = 0; c1 < 4; c1++) {
				for (int c2 = 0; c2 < 4; c2++) {
					for (int c3 = 0; c3 < 4; c3++) {
						if (c1 == 0 && c2 == 2 && c3 == 1) {
							continue;
						}
						for (int c4 = 0; c4 < 4; c4++) {
							if (c2 == 0 && c3 == 2 && c4 == 1
									|| c2 == 0 && c3 == 1 && c4 == 2
									|| c2 == 2 && c3 == 0 && c4 == 1
									|| c1 == 0 && c2 == 2 && c4 == 1
									|| c1 == 0 && c3 == 2 && c4 == 1) {
								continue;
							}
							dp[len][c2][c3][c4] += dp[len - 1][c1][c2][c3];
							dp[len][c2][c3][c4] %= mod;
						}
					}
				}
			}
		}

		int ans = 0;
		for (int c1 = 0; c1 < 4; c1++) {
			for (int c2 = 0; c2 < 4; c2++) {
				for (int c3 = 0; c3 < 4; c3++) {
					ans += dp[N][c1][c2][c3];
					ans %= mod;
				}
			}
		}
		System.out.println(ans);
	}
}
