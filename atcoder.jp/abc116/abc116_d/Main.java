import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.AbstractCollection;
import java.util.Scanner;
import java.util.LinkedList;

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
            int N = in.nextInt();
            int K = in.nextInt();
            int[][] sushi = new int[N][2];
            for (int i = 0; i < N; i++) {
                sushi[i] = new int[]{in.nextInt(), in.nextInt()};
            }
            Arrays.sort(sushi, (a, b) -> Integer.compare(b[1], a[1]));

            int[] count = new int[N + 1];
            LinkedList<int[]> que = new LinkedList<>();
            long kinds = 0;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += sushi[i][1];
                int kind = sushi[i][0];
                count[kind]++;
                if (count[kind] == 1) {
                    kinds++;
                }
                if (count[kind] >= 2) {
                    que.add(new int[]{sushi[i][1], i});
                }
            }

            long max = sum + kinds * kinds;
            for (int i = K; i < N; i++) {
                int kind = sushi[i][0];
                if (count[kind] <= 0) {
                    if (que.isEmpty()) {
                        break;
                    }
                    int[] q = que.removeLast();
                    while (count[sushi[q[1]][0]] < 2) {
                        q = que.isEmpty() ? null : que.removeLast();
                        if (q == null) {
                            break;
                        }
                    }
                    if (q == null) {
                        break;
                    }
                    int index = q[1];
                    sum += (sushi[i][1] - sushi[index][1]);
                    kinds++;
                    max = Math.max(max, sum + kinds * kinds);
                    count[kind]++;
                    count[sushi[index][0]]--;
                }
            }

            out.println(max);
        }

    }
}

