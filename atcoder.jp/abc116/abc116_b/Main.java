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
            int s = in.nextInt();
            boolean[] exists = new boolean[1000001];

            int index = 0;
            while (true) {
                index++;
                if (exists[s]) {
                    out.println(index);
                    return;
                }
                exists[s] = true;
                if (s % 2 == 0) {
                    s = s / 2;
                } else {
                    s = 3 * s + 1;
                }
            }
        }

    }
}

