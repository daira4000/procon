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
            int[] d = new int[N];
            for (int i = 0; i < N; i++) {
                d[i] = in.nextInt();
            }

            long sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    sum += d[i] * d[j];
                }
            }
            out.println(sum);
        }

    }
}

