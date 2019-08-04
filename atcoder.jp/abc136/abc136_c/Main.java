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
            long[] H = new long[N];
            for (int i = 0; i < N; i++) {
                H[i] = in.nextLong();
            }
            for (int i = N - 1; 0 < i; i--) {
                long diff = H[i] - H[i - 1];
                if (diff < -1) {
                    out.println("No");
                    return;
                } else if (diff == -1) {
                    H[i - 1]--;
                }
            }
            out.println("Yes");
        }

    }
}

