import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.HashMap;

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
            String S = in.next();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : S.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            String ret = "No";
            if (map.entrySet().stream().filter(e -> e.getValue() == 2).count() == 2) {
                ret = "Yes";
            }
            out.println(ret);
        }

    }
}

