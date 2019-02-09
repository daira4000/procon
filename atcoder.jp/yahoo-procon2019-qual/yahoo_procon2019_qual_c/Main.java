import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long K = in.nextLong();
		long A = in.nextLong();
		long B = in.nextLong();

		if (B <= A + 2 || K < 3 || (1 + K) - 2 < A) {
			System.out.println(1 + K);
			return;
		}

		long diff = B - A;
		long K2 = K - (A - 1);
		long maisu = A + (K2 / 2) * diff + (K2 % 2);

		System.out.println(maisu);
	}
}
