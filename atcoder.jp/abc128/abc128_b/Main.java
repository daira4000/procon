import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            List<Values> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Values(in.next(), in.nextInt(), i + 1));
            }

            Collections.sort(list);
            for (Values val : list) {
                out.println(val.idx);
            }
        }

        class Values implements Comparable<Values> {
            String S;
            int P;
            int idx;

            Values(String S, int P, int idx) {
                this.S = S;
                this.P = P;
                this.idx = idx;
            }

            public int compareTo(Values o) {
                int cmp = S.compareTo(o.S);
                if (cmp != 0) {
                    return cmp;
                }
                return Integer.compare(o.P, P);
            }

        }

    }
}

