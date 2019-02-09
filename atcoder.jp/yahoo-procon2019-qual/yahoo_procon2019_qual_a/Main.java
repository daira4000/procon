import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int N = in.nextInt();
		int K = in.nextInt();

		int temp = (int) (N / 2.0 + 0.5);
		if (temp >= K) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
