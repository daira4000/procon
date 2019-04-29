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
            int[] H = new int[N];
            for (int i = 0; i < N; i++) {
                H[i] = in.nextInt();
            }
            int count = 1;
            int max = H[0];
            for (int i = 1; i < N; i++) {
                if (max <= H[i]) {
                    count++;
                    max = H[i];
                }
            }
            out.println(count);
        }

    }
}

