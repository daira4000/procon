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
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();
            int Q = in.nextInt();
            int[] A = new int[N];
            Arrays.fill(A, K - Q);
            for (int i = 0; i < Q; i++) {
                int index = in.nextInt();
                A[index - 1]++;
            }
            StringBuilder sb = new StringBuilder(4 * N);
            for (int i = 0; i < N; i++) {
                sb.append(A[i] > 0 ? "Yes" : "No").append('\n');
            }
            out.println(sb.toString());
        }

    }
}

