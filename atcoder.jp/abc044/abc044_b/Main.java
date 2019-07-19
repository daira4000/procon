import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.function.Function;

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
            String w = in.next();
            Map<Integer, List<Integer>> map = w.chars().boxed().collect(Collectors.groupingBy(Function.identity()));
            String ret = map.values().stream().filter(l -> l.size() % 2 != 0).count() == 0 ? "Yes" : "No";
            out.println(ret);
        }

    }
}

