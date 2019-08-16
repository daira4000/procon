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
            long x = in.nextLong();
            long[] a = new long[N + 2];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextLong();
            }
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                long temp = a[i - 1] + a[i] - x;
                if (temp > 0) {
                    if (a[i] >= temp) {
                        cnt += temp;
                        a[i] -= temp;
                    } else {
                        cnt += a[i];
                        a[i] = 0;
                        if (a[i - 1] > x) {
                            cnt += a[i - 1] - x;
                        }
                    }
                }
            }
            out.println(cnt);
        }

    }
}

