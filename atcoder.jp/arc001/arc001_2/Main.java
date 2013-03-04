import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Main {
	public static void main(String[] args) throws IOException {
		Main a = new Main();

		if (true) {
			a.execute();
		} else {
			String[][] check = { { "7", "34", "5" }, { "19", "28", "2" }, { "10", "10", "0" }, { "0", "0", "0" },
					{ "0", "40", "4" }, { "40", "0", "4" }, { "0", "33", "6" }, { "39", "0", "5" } };
			for (String[] ss : check) {
				System.out.print(ss[0] + " " + ss[1] + ":");
				int answer = a.solver(ss[0], ss[1]);
				if (answer == Integer.valueOf(ss[2])) {
					System.out.println(true);
				} else {
					System.out.println(String.valueOf(answer) + " != " + ss[2]);
				}
			}
		}
	}

	private void execute() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String[] ss = s.split(" ");
		System.out.println(solver(ss[0], ss[1]));
	}

	public int solver(String A, String B) {
		int a = Integer.valueOf(A);
		int b = Integer.valueOf(B);
		int dif = Math.abs(a - b);
		int count10 = dif / 10 + (dif % 10 > 7 ? 1 : 0);
		dif = Math.abs(dif - (count10 * 10));
		int count5 = dif / 5 + (dif % 5 > 3 ? 1 : 0);
		dif = Math.abs(dif - (count5 * 5));

		return count10 + count5 + dif;
	}

}
