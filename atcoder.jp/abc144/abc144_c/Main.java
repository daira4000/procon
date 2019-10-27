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
            long N = in.nextLong();
            long move = N - 1;
            long max = (long) Math.sqrt(N);
            for (long i = 2; i <= max; i++) {
                long temp = i + N / i - 2;
                if (N % i == 0 && temp < move) {
                    move = temp;
                }
            }
            out.println(move);
        }

    }
}

