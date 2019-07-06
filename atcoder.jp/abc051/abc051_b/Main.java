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
            int K = in.nextInt();
            int S = in.nextInt();

            long count = 0;
            for (int X = 0; X <= K; X++) {
                for (int Y = 0; Y <= K; Y++) {
                    int Z = S - (X + Y);
                    if (0 <= Z && Z <= K) {
                        count++;
                    }
                }
            }
            out.println(count);
        }

    }
}

