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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            int[] ans = new int[N];
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    ans[0] += A[i];
                } else {
                    ans[0] -= A[i];
                }
            }
            A[0] -= ans[0] / 2;
            A[N - 1] -= ans[0] / 2;
            for (int i = 1; i < N; i++) {
                ans[i] = A[i - 1] * 2;
                A[i] -= A[i - 1];
            }

            StringBuilder sb = new StringBuilder();
            for (int v : ans) {
                sb.append(v).append(' ');
            }
            out.println(sb.substring(0, sb.length() - 1));
        }

    }
}

