import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
            int H = in.nextInt();
            int W = in.nextInt();
            char[][] Ss = new char[H][W];
            for (int i = 0; i < H; i++) {
                Ss[i] = in.next().toCharArray();
            }
            int[][][] counts = new int[H][W][2];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (Ss[i][j] == '.') {
                        // H
                        if (counts[i][j][0] == 0) {
                            for (int k = i; k < H; k++) {
                                if (Ss[k][j] == '.') {
                                    counts[i][j][0]++;
                                } else {
                                    break;
                                }
                            }
                            for (int k = i; k < H; k++) {
                                if (Ss[k][j] == '.') {
                                    counts[k][j][0] = counts[i][j][0];
                                } else {
                                    break;
                                }
                            }
                        }
                        // W
                        if (counts[i][j][1] == 0) {
                            for (int k = j; k < W; k++) {
                                if (Ss[i][k] == '.') {
                                    counts[i][j][1]++;
                                } else {
                                    break;
                                }
                            }
                            for (int k = j; k < W; k++) {
                                if (Ss[i][k] == '.') {
                                    counts[i][k][1] = counts[i][j][1];
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    max = Math.max(max, counts[i][j][0] + counts[i][j][1] - 1);
                }
            }
            out.println(max);
        }

    }
}

