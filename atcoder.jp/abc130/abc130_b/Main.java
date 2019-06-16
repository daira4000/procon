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
            int X = in.nextInt();
            int[] L = new int[N + 1];
            for (int i = 0; i < N; i++) {
                L[i] = in.nextInt();
            }

            int current = 0;
            int count = 0;
            for (int n : L) {
                if (current <= X) {
                    count++;
                }
                current += n;
            }
            out.println(count);
        }

    }
}

