import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.util.Deque;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();
            int K = in.nextInt();
            Map<Integer, List<Integer>> friend = new HashMap<>();
            Map<Integer, List<Integer>> block = new HashMap<>();
            for (int i = 0; i < N; i++) {
                friend.put(i + 1, new ArrayList<>());
                block.put(i + 1, new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int A = in.nextInt();
                int B = in.nextInt();
                friend.get(A).add(B);
                friend.get(B).add(A);
            }
            for (int i = 0; i < K; i++) {
                int C = in.nextInt();
                int D = in.nextInt();
                block.get(C).add(D);
                block.get(D).add(C);
            }

            int[] ans = new int[N];
            for (int i = 0; i < N; i++) {
                if (ans[i] > 0) continue;
                int c = i + 1;
                Set<Integer> kouho = new HashSet<>();
                kouho.add(c);
                Deque<Integer> que = new ArrayDeque<>(friend.get(c));
                while (!que.isEmpty()) {
                    int f = que.removeFirst();
                    if (kouho.contains(f)) continue;
                    kouho.add(f);
                    for (int ff : friend.get(f)) {
                        que.addFirst(ff);
                    }
                }
                for (int d : kouho) {
//                kouho2.remove(d);
//                kouho2.removeAll(friend.get(d));
                    block.get(d).removeIf(a -> !kouho.contains(a));
//                kouho.removeAll(block.get(d));
                    ans[d - 1] = kouho.size() - friend.get(d).size() - 1 - block.get(d).size();
                }
            }
            String s = IntStream.of(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            out.println(s);
        }

    }

    static class MyScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public MyScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

