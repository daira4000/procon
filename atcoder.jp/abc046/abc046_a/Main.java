import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

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
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            Set<Integer> set = new HashSet<>(Arrays.asList(a, b, c));
            out.println(set.size());
        }

    }
}

