import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.stream.Stream;
import java.util.Collection;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.stream.Collectors;

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
            char[] s = in.next().toCharArray();
            int index = 0;
            LinkedList<Character> ans = new LinkedList<>();
            for (char c : s) {
                if (c == 'B') {
                    if (!ans.isEmpty()) {
                        ans.removeLast();
                    }
                } else {
                    ans.add(c);
                }
            }
            out.println(ans.stream().map(Object::toString).collect(Collectors.joining()));
        }

    }
}

