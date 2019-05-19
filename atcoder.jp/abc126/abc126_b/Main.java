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
            String S = in.next();
            String a = S.substring(0, 2);
            String b = S.substring(2);
            boolean yymm = isYY(a) && isMM(b);
            boolean mmyy = isMM(a) && isYY(b);
            if (yymm && mmyy) {
                out.println("AMBIGUOUS");
            } else if (!yymm && mmyy) {
                out.println("MMYY");
            } else if (yymm && !mmyy) {
                out.println("YYMM");
            } else {
                out.println("NA");
            }
        }

        private boolean isMM(String a) {
            try {
                int n = Integer.parseInt(a);
                return 0 < n && n < 13;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private boolean isYY(String a) {
            try {
                Integer.parseInt(a);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

    }
}

