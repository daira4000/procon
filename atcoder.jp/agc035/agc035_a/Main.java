import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Collection;
import java.util.Scanner;
import java.util.Optional;
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
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }

            String ret = "No";
            Map<Integer, List<Integer>> group = Arrays.stream(a).boxed().collect(Collectors.groupingBy(n -> n));
            int kinds = group.size();
            if (kinds == 1 && group.containsKey(0)) {
                ret = "Yes";
            } else if (kinds == 2 && group.containsKey(0) && group.get(0).size() == N / 3) {
                ret = "Yes";
            } else if (kinds == 3 && group.values().stream().filter(l -> l.size() == N / 3).count() == 3) {
                int n = group.keySet().stream().reduce((x, y) -> x ^ y).get();
                if (n == 0) {
                    ret = "Yes";
                }
            }
            out.println(ret);
        }

    }
}

