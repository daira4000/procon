import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		double sum = 0;
		for (int i = 0; i < N; i++) {
			double x = in.nextDouble();
			String u = in.next();
			if (u.equals("JPY")) {
				sum += x;
			} else {
				sum += (x * 380000.0);
			}
		}
		System.out.println(sum);
	}
}
