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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[] D = new int[10];
            for (int i = 0; i < K; i++) {
                D[in.nextInt()] = 1;
            }

            int ans = calc(N, D, 0, 0);
            out.println(ans);
        }

        private int calc(int N, int[] D, int v, int n) {
            if (n > 5) {
                return 99999;
            }
            if (N <= v) {
                return v;
            }
            int ret = 99999;
            for (int i = 0; i < D.length; i++) {
                if (D[i] == 1) {
                    continue;
                }
                ret = Math.min(ret, calc(N, D, i * (int) Math.pow(10, n) + v, n + 1));
            }
            return ret;
        }

    }
}

