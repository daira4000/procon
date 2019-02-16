import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] A = new int[M];
		for (int i = 0; i < N; i++) {
			int K = in.nextInt();
			for (int j = 0; j < K; j++) {
				int index = in.nextInt();
				A[index-1]++;
			}
		}
		int count = 0;
		for (int a : A) {
			if (a == N) {
				count++;
			}
		}
		System.out.println(count);
	}
}
