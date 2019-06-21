import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.ArrayList;

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
            int[] ABC = new int[]{in.nextInt(), in.nextInt(), in.nextInt()};
            Map<Integer, List<Integer>> collect = Arrays.stream(ABC).mapToObj(Integer::valueOf).collect(Collectors.groupingBy(Function.identity()));
            out.println(collect.getOrDefault(5, new ArrayList<>()).size() == 2 && collect.getOrDefault(7, new ArrayList<>()).size() == 1 ? "YES" : "NO");
        }

    }
}

