import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            User[] us = new User[N + 1];
            for (int i = 0; i <= N; i++) {
                us[i] = new User();
            }
            int Q = in.nextInt();
            for (int i = 0; i < Q; i++) {
                int action = in.nextInt();
                int a = in.nextInt();
                if (action == 1) {
                    int b = in.nextInt();
                    us[a].follow.add(b);
                    us[b].follower.add(a);
                } else if (action == 2) {
                    for (int b : us[a].follower) {
                        us[a].follow.add(b);
                    }
                } else {
                    Set<Integer> temp = new HashSet<>();
                    for (int x : us[a].follow) {
                        for (int b : us[x].follow) {
                            if (a != b) {
                                temp.add(b);
                                us[b].follower.add(a);
                            }
                        }
                    }
                    us[a].follow.addAll(temp);
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    out.print(us[i].follow.contains(j) ? 'Y' : 'N');
                }
                out.println();
            }
        }

        class User {
            Set<Integer> follow = new HashSet<>();
            Set<Integer> follower = new HashSet<>();

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

