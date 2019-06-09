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
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        int P;
        int Q;
        int R;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            P = in.nextInt();
            Q = in.nextInt();
            R = in.nextInt();
            out.println(Math.min(P + Q, Math.min(Q + R, R + P)));
        }

    }
}

