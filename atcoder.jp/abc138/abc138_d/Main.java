import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
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
            int N = in.nextInt();
            int Q = in.nextInt();
            List<D.Node> nodes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                D.Node node = new D.Node();
                nodes.add(node);
            }
            for (int i = 0; i < N - 1; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                nodes.get(a - 1).nodes.add(nodes.get(b - 1));
            }
            for (int i = 0; i < Q; i++) {
                int p = in.nextInt();
                int x = in.nextInt();
                nodes.get(p - 1).point += x;
            }
            nodes.get(0).calc();
            StringBuilder sb = new StringBuilder();
            for (D.Node node : nodes) {
                sb.append(node.point).append(' ');
            }
            out.println(sb.substring(0, sb.length() - 1));
        }

        private static class Node {
            int point;
            List<D.Node> nodes = new ArrayList<>();

            public void calc() {
                for (D.Node node : nodes) {
                    node.calc(point);
                }
            }

            public void calc(int p) {
                point += p;
                for (D.Node node : nodes) {
                    node.calc(point);
                }
            }

        }

    }
}

