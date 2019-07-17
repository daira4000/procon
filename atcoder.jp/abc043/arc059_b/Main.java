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
            String s = in.next();
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length - 1; i++) {
                if (cs[i] == cs[i + 1]) {
                    out.println((i + 1) + " " + (i + 2));
                    return;
                }
                if (i < cs.length - 2 && cs[i] == cs[i + 2]) {
                    out.println((i + 1) + " " + (i + 3));
                    return;
                }
            }
            out.println("-1 -1");
        }

    }
}

