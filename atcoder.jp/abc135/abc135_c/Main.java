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
            int[] A = new int[N + 1];
            int[] B = new int[N];
            for (int i = 0; i < N + 1; i++) {
                A[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                B[i] = in.nextInt();
            }

            long count = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] <= B[i]) {
                    count += A[i];
                    B[i] -= A[i];
                    if (A[i + 1] <= B[i]) {
                        count += A[i + 1];
                        A[i + 1] = 0;
                    } else {
                        count += B[i];
                        A[i + 1] -= B[i];
                    }
                } else {
                    count += B[i];
                }
            }
            out.println(count);
        }

    }
}

