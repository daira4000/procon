import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        int N;
        int M;
        boolean[] a;
        int mod = (int) (1e9 + 7);

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            N = in.nextInt();
            M = in.nextInt();
            a = new boolean[N + 1];
            Arrays.fill(a, true);
            for (int i = 0; i < M; i++) {
                a[in.nextInt()] = false;
            }

            int[] dp = new int[N + 1];
            dp[0] = 1;
            for (int i = 1; i <= N; i++) {
                if (a[i]) {
                    dp[i] = dp[i - 1];
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2];
                    }
                    dp[i] %= mod;
                }
            }
            out.println(dp[N]);
        }

    }
}

