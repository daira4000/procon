import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long N = in.nextLong();

            List<Long> list = divisor(N);
            list.remove(Long.valueOf(1));

            long ret = 0;
            for (Long n : list) {
                if (N / (n - 1) == N % (n - 1)) {
                    ret += (n - 1);
                }
            }
            out.println(ret);
        }

        private List<Long> divisor(long n) {
            List<Long> ret = new ArrayList<>();
            for (long i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    ret.add(i);
                    if (i * i != n) {
                        ret.add(n / i);
                    }
                }
            }
            ret.sort(Comparator.naturalOrder());
            return ret;
        }

    }
}

