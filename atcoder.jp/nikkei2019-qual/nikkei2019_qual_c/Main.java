import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int N = in.nextInt();
		LinkedList<Long[]> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			long A = in.nextLong();
			long B = in.nextLong();
			list.add(new Long[] {A, B, 0L});
		}
		LinkedList<Long[]>list2 = new LinkedList<>(list);
		list.sort((a, b)->{
			int compare = Long.compare( (b[1] + b[0]), (a[1] + a[0]));
			if (compare != 0) {
				return compare;
			}
			return Long.compare(b[1], a[1]);
		});
		list2.sort((a, b)->{
			int compare = Long.compare( (b[1] + b[0]), (a[1] + a[0]));
			if (compare != 0) {
				return compare;
			}
			return Long.compare(b[0], a[0]);
		});

		long happy = 0;
		while (!list.isEmpty()) {
			Long[] ls = list.pollFirst();
			while (ls != null && ls[2] != 0) {
				ls = list.pollFirst();
			}
			if (ls == null) {
				break;
			}
			happy += ls[0];
			ls[2] = 1L;

			ls = list2.pollFirst();
			while (ls != null && ls[2] != 0) {
				ls = list.pollFirst();
			}
			if (ls == null) {
				break;
			}
			happy -= ls[1];
			ls[2] = 1L;
		}
		System.out.println(happy);
	}
}
