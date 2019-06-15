import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.OptionalInt;

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
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int D = in.nextInt();
            int E = in.nextInt();

            int t = Stream.of(A, B, C, D, E).mapToInt(n -> n % 10).filter(n -> n > 0).min().orElse(10);
            int sum = Stream.of(A, B, C, D, E).mapToInt(n -> (int) Math.ceil(n / 10.0) * 10).sum();
            out.println(sum - (10 - t));
        }

    }
}

