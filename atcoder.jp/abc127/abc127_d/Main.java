import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();

            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            Arrays.sort(A);

            Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
            for (int i = 0; i < M; i++) {
                int value = in.nextInt();
                int key = in.nextInt();
                if (map.containsKey(key)) {
                    value += map.get(key);
                }
                map.put(key, value);
            }

            int index = 0;
            for (Map.Entry<Integer, Integer> entry :
                    map.entrySet()) {
                int value = entry.getValue();
                int key = entry.getKey();
                if (N <= index || key <= A[index]) {
                    break;
                }
                for (int i = 0; i < value; i++) {
                    if (N <= index || key <= A[index]) {
                        break;
                    }
                    A[index++] = key;
                }
            }

            out.println(Arrays.stream(A).asLongStream().sum());
        }

    }
}

