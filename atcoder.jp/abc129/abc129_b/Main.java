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
        int N;
        int[] W;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            N = in.nextInt();
            W = new int[N];
            for (int i = 0; i < N; i++) {
                W[i] = in.nextInt();
            }

            int[] ls = new int[N];
            ls[0] = W[0];
            int[] rs = new int[N];
            rs[N - 1] = W[N - 1];
            for (int i = 1; i < N; i++) {
                ls[i] = ls[i - 1] + W[i];
                rs[N - 1 - i] = rs[N - 1 - i + 1] + W[N - 1 - i];
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N - 1; i++) {
                int diff = Math.abs(ls[i] - rs[i + 1]);
                min = Math.min(min, diff);
            }
            out.println(min);
        }

    }
}

