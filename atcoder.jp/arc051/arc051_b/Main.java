import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int K = in.nextInt();
		int a = 1, b = 1;

		for (int i = 0; i < K; i++) {
			int tmp = a;
			a = a + b;
			b = tmp;
		}
		System.out.println(String.format("%d %d", a, b));
	}

}
