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
            long K = in.nextLong();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            long[] Asum = new long[N + 1];
            Asum[0] = 0;
            for (int i = 1; i <= N; i++) {
                Asum[i] = Asum[i - 1] + A[i - 1];
            }

            long count = 0;
            int l = 0;
            int r = 0;
            while (r <= N) {
                long sum;
                while (r <= N) {
                    sum = Asum[r] - Asum[l];
                    if (K <= sum) {
                        count += N - r + 1;
                        break;
                    }
                    r++;
                }
                l++;
            }
            out.println(count);
        }

    }
}

