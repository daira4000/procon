import java.util.Scanner;

public class Main {

	static int N, A, B, C;
	static int[] ls;
	static int INF = (int) 10e8;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		A = in.nextInt();
		B = in.nextInt();
		C = in.nextInt();
		ls = new int[N];
		for (int i = 0; i < N; i++) {
			ls[i] = in.nextInt();
		}

		int mp = dfs(0, 0, 0, 0);
		System.out.println(mp);
	}

	private static int dfs(int cur, int a, int b, int c) {
		if (cur == N) {
			if (a == 0 || b == 0 || c == 0) {
				return INF;
			}
			return Math.abs(a - A) + Math.abs(b - B) + Math.abs(c - C) - 30;
		}
		int ret0 = dfs(cur + 1, a, b, c);
		int ret1 = dfs(cur + 1, a + ls[cur], b, c) + 10;
		int ret2 = dfs(cur + 1, a, b + ls[cur], c) + 10;
		int ret3 = dfs(cur + 1, a, b, c + ls[cur]) + 10;
		return Math.min(Math.min(ret0, ret1), Math.min(ret2, ret3));
	}

}
