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
            int K = in.nextInt();

            double ret = 0;
            for (int current = 1; current <= N; current++) {
                double temp = 1;
                int score = current;
                while (score < K) {
                    score *= 2;
                    temp *= 0.5;
                }
                ret += ((1 / (double) N) * temp);
            }
            out.printf("%.12f", ret);
        }

    }
}

