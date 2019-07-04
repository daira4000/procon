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
            int M = in.nextInt();
            int C = in.nextInt();

            int[] B = new int[M];
            for (int i = 0; i < M; i++) {
                B[i] = in.nextInt();
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                int sum = C;
                for (int j = 0; j < M; j++) {
                    sum += B[j] * in.nextInt();
                }
                if (sum > 0) {
                    count++;
                }
            }
            out.println(count);
        }

    }
}

