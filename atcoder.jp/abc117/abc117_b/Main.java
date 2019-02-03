import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int N = in.nextInt();
		int[] L = new int[N];
		for (int i = 0; i < N; i++) {
			L[i] = in.nextInt();
		}
		int max = Arrays.stream(L).max().getAsInt();
		int sum = Arrays.stream(L).sum();
		String ans = max < (sum - max) ? "Yes" : "No";
		System.out.println(ans);
	}
}
