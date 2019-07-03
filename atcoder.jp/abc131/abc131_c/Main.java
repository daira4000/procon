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
            long A = in.nextLong();
            long B = in.nextLong();
            long C = in.nextLong();
            long D = in.nextLong();
            long CD = lcm(C, D);
            long A2 = A - 1;
            out.println((B - B / C - B / D + B / CD) - (A2 - A2 / C - A2 / D + A2 / CD));
        }

        long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        long lcm(long a, long b) {
            return a / gcd(a, b) * b;
        }

    }
}

