import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
            String S = in.next();
            boolean easy = true;
            char[] rs = {'R', 'U', 'D'};
            char[] ls = {'L', 'U', 'D'};
            Arrays.sort(rs);
            Arrays.sort(ls);
            for (int i = 0; easy && i < S.length(); i++) {
                char c = S.charAt(i);
                if (i % 2 == 0) {
                    easy = Arrays.binarySearch(rs, c) >= 0;
                } else {
                    easy = Arrays.binarySearch(ls, c) >= 0;
                }
            }
            out.println(easy ? "Yes" : "No");
        }

    }
}

