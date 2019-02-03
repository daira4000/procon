import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int N = in.nextInt();
		int M = in.nextInt();
		int[] X = new int[M];
		for (int i = 0; i < M; i++) {
			X[i] = in.nextInt();
		}
		Arrays.parallelSort(X);

		if (N >= M) {
			System.out.println(0);
			return;
		}

		int[] diff = new int[M];
		for (int i = 0; i < M - 1; i++) {
			diff[i] = Math.abs(X[i] - X[i + 1]);
		}
		Arrays.parallelSort(diff);

		int temp = 0;
		for (int i = 1; i < N; i++) {
			temp += diff[M - i];
		}
		System.out.println(X[M - 1] - X[0] - temp);
	}
}
