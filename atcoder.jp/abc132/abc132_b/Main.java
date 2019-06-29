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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }

            int count = 0;
            for (int i = 1; i < n - 1; i++) {
                int[] ps = new int[]{p[i - 1], p[i], p[i + 1]};
                Arrays.sort(ps);
                if (ps[1] == p[i]) {
                    count++;
                }
            }
            out.println(count);
        }

    }
}

