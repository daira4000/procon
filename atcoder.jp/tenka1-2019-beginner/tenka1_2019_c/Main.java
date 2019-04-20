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
            String S = in.next();
            char[] cs = S.toCharArray();

            int[] cb = new int[N + 1];
            int[] cw = new int[N + 1];

            for (int i = 1; i < N; i++) {
                cb[i] += cb[i - 1] + (cs[i - 1] == '#' ? 1 : 0);
            }
            for (int i = N - 1; i >= 0; i--) {
                cw[i] += cw[i + 1] + (cs[i] == '.' ? 1 : 0);
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                ans = Math.min(ans, cb[i] + cw[i + 1]);
            }
            out.println(ans);
        }

    }
}

