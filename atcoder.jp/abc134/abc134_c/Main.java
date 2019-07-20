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
            long[] A = new long[N];
            long[] max = {0, 0};
            for (int i = 0; i < N; i++) {
                A[i] = in.nextLong();
                if (max[0] <= A[i]) {
                    max[1] = max[0];
                    max[0] = A[i];
                } else if (max[1] < A[i]) {
                    max[1] = A[i];
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (A[i] == max[0]) {
                    sb.append(max[1]).append('\n');
                } else {
                    sb.append(max[0]).append('\n');
                }
            }
            out.print(sb.toString());
        }

    }
}

