import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.Comparator;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();

            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            List<Integer> posi = Arrays.stream(A).filter(n -> 0 <= n).mapToObj(n -> Integer.valueOf(n)).collect(Collectors.toList());
            List<Integer> nega = Arrays.stream(A).filter(n -> 0 > n).mapToObj(n -> Integer.valueOf(n)).collect(Collectors.toList());
            posi.sort(Comparator.naturalOrder());
            nega.sort(Comparator.naturalOrder());

            StringBuilder sb = new StringBuilder();
            int ret;
            if (posi.isEmpty()) {
                ret = nega.remove(nega.size() - 1);
                for (Integer n : nega) {
                    sb.append(ret).append(' ').append(n).append(System.lineSeparator());
                    ret -= n;
                }
            } else if (nega.isEmpty()) {
                ret = posi.remove(0);
                int temp = posi.remove(posi.size() - 1);
                for (Integer n : posi) {
                    sb.append(ret).append(' ').append(n).append(System.lineSeparator());
                    ret -= n;
                }
                sb.append(temp).append(' ').append(ret).append(System.lineSeparator());
                temp -= ret;
                ret = temp;
            } else {
                ret = posi.remove(posi.size() - 1);
                int temp = nega.remove(0);
                for (Integer n : posi) {
                    sb.append(temp).append(' ').append(n).append(System.lineSeparator());
                    temp -= n;
                }
                for (Integer n : nega) {
                    sb.append(ret).append(' ').append(n).append(System.lineSeparator());
                    ret -= n;
                }
                sb.append(ret).append(' ').append(temp).append(System.lineSeparator());
                ret -= temp;
            }
            out.println(ret);
            out.print(sb.toString());
        }

    }
}

