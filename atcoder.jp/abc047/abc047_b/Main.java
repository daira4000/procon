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
            int W = in.nextInt();
            int H = in.nextInt();
            int N = in.nextInt();
            int x1 = 0, x2 = W, y1 = 0, y2 = H;
            for (int i = 0; i < N; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int a = in.nextInt();
                if (a == 1) {
                    x1 = Math.max(x1, x);
                } else if (a == 2) {
                    x2 = Math.min(x2, x);
                } else if (a == 3) {
                    y1 = Math.max(y1, y);
                } else if (a == 4) {
                    y2 = Math.min(y2, y);
                }
            }
            if (x2 <= x1 || y2 <= y1) {
                out.println(0);
            } else {
                out.println((x2 - x1) * (y2 - y1));
            }
        }

    }
}

