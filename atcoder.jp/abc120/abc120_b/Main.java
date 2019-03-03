import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int A = in.nextInt();
		int B = in.nextInt();
		int K = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= Math.max(A, B); i++) {
			if (A % i == 0 && B % i == 0) {
				list.add(i);
			}
		}
		System.out.println(list.get(list.size() - K));
	}
}
