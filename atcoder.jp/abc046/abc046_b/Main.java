import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();

            long[][] dp = new long[N][K];
            for (int i = 0; i < K; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < K; j++) {
                    for (int k = 0; k < K; k++) {
                        if (j != k) {
                            dp[i][k] += dp[i - 1][j];
                        }
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += dp[N - 1][i];
            }
            out.println(sum);
        }

    }
}

