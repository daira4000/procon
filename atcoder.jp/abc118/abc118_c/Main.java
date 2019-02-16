import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			A.add(in.nextInt());
		}

		while (A.size() > 1) {
			int min = A.stream().min(Comparator.naturalOrder()).get();
			A = A.stream().map(n -> n % min).filter(n -> n > 0).collect(Collectors.toList());
			A.add(min);
		}
		System.out.println(A.get(0));
	}
}
