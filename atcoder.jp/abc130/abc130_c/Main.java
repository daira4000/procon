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
            long W = in.nextLong();
            long H = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();

            double v = (W * H) / 2.0;
            int w = (x * 2 == W) && (y * 2 == H) ? 1 : 0;
            out.printf("%.6f %d\n", v, w);
        }

    }
}

