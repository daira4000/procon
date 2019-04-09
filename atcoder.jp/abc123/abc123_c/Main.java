import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Collection;
import java.util.Scanner;
import java.util.Optional;
import java.util.Comparator;

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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long N = in.nextLong();
            long A = in.nextLong();
            long B = in.nextLong();
            long C = in.nextLong();
            long D = in.nextLong();
            long E = in.nextLong();

            long min = Arrays.asList(A, B, C, D, E).stream().min(Comparator.naturalOrder()).get();
            // out.println(4L + (long)Math.ceil((double)N / min));
            out.println(4L + (N + (min - 1L)) / min);
        }

    }
}

