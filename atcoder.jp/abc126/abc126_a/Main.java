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
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();
            String S = in.next();
            StringBuilder sb = new StringBuilder(S);
            sb.replace(K - 1, K, S.substring(K - 1, K).toLowerCase());
            out.println(sb.toString());
        }

    }
}

