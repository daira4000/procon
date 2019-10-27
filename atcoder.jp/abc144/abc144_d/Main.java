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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            double a = in.nextInt();
            double b = in.nextInt();
            double x = in.nextInt();
            double ans = 0;

            double h = x / (a * a);
            double atan;
            if (h * 2 >= b) {
                atan = Math.atan2(Math.abs(b - h) * 2.0, a);
            } else {
                double z = x * 2.0 / b / a;
                atan = Math.atan2(b, z);
            }
            ans = Math.toDegrees(atan);

            out.printf("%.10f\n", ans);
        }

    }
}

