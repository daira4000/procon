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
            int ans = 0;
            if (N < 10) {
                ans = N;
            } else if (N < 100) {
                ans = 9;
            } else if (N < 1000) {
                ans = 9 + N % 100 + 1 + 100 * (int) Math.floor((N - 100) / 100.0);
            } else if (N < 10000) {
                ans = 909;
            } else if (N < 100000) {
                ans = 909 + N % 10000 + 1 + 10000 * (int) Math.floor((N - 10000) / 10000.0);
            } else {
                ans = 90909;
            }
            out.println(ans);
        }

    }
}

