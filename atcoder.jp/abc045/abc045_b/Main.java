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
            String SA = in.next();
            String SB = in.next();
            String SC = in.next();
            int ia = 0, ib = 0, ic = 0;
            int p = 0;
            while (true) {
                char win = 0;
                switch (p) {
                    case 0:
                        if (ia >= SA.length()) {
                            win = 'A';
                        } else {
                            p = SA.charAt(ia++) - 'a';
                        }
                        break;
                    case 1:
                        if (ib >= SB.length()) {
                            win = 'B';
                        } else {
                            p = SB.charAt(ib++) - 'a';
                        }
                        break;
                    default:
                        if (ic >= SC.length()) {
                            win = 'C';
                        } else {
                            p = SC.charAt(ic++) - 'a';
                        }
                        break;
                }
                if (win != 0) {
                    out.println(win);
                    return;
                }
            }
        }

    }
}

