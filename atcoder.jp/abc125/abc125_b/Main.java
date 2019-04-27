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
            int[] C = new int[N];
            int[] V = new int[N];

            int sum = 0;
            for (int i = 0; i < N; i++) {
                V[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                C[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                int diff = V[i] - C[i];
                if (diff > 0) {
                    sum += diff;
                }
            }
            out.println(sum);
        }

    }
}

