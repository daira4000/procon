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
            int R = in.nextInt();
            int G = in.nextInt();
            int B = in.nextInt();
            int N = in.nextInt();

            long count = 0;

            int rd = N / R;
            for (int i = 0; i <= rd; i++) {
                int n2 = N - R * i;
                int rg = n2 / G;
                for (int j = 0; j <= rg; j++) {
                    int n3 = n2 - G * j;
                    if (n3 == 0 || n3 % B == 0) {
                        count += 1;
                    }
                }
            }
            out.println(count);
        }

    }
}

