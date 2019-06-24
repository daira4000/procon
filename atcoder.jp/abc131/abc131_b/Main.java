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
            int L = in.nextInt();

            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int score = L + i;
                sum += score;
                if (Math.abs(score) < Math.abs(min)) {
                    min = score;
                }
            }
            sum -= min;
            out.println(sum);
        }

    }
}

