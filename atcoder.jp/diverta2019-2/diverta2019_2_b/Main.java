import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Collection;
import java.util.Scanner;
import java.util.HashMap;
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
            int N = in.nextInt();
            if (N == 1) {
                out.println(1);
                return;
            }
            int[][] balls = new int[N][2];
            for (int i = 0; i < N; i++) {
                balls[i] = new int[]{in.nextInt(), in.nextInt()};
            }
            Map<B.Pair, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    B.Pair p = new B.Pair(balls[i][0] - balls[j][0], balls[i][1] - balls[j][1]);
                    map.put(p, map.getOrDefault(p, 0) + 1);
                }
            }
            int maxVal = map.values().stream().mapToInt(n -> n).max().getAsInt();
            out.println(N - maxVal);
        }

        static class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                B.Pair pair = (B.Pair) o;
                return x == pair.x &&
                        y == pair.y;
            }

            public int hashCode() {
                return Objects.hash(x, y);
            }

        }

    }
}

