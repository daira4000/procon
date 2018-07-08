import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int N = in.nextInt();
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			long A = in.nextLong();
			min = Long.min(min, A);
			max = Long.max(max, A);
		}
		System.out.println(max - min);
	}
}
