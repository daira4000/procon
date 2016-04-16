import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int r = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		int x3 = in.nextInt();
		int y3 = in.nextInt();

		// 円
		int xa = x1 - r;
		int xb = x1 + r;
		int ya = y1 - r;
		int yb = y1 + r;

		// 位置がかぶってない
		if (x3 <= xa || xb <= x2 || y3 <= ya || yb <= y2) {
			System.out.println("YES");
			System.out.println("YES");
			return;
		}

		// 円が覆われている
		if (x2 <= xa && xb <= x3 && y2 <= ya && yb <= y3) {
			System.out.println("NO");
			System.out.println("YES");
			return;
		}

		// 四角が覆われている
		double rr = Math.pow(r, 2);
		boolean a = (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)) < rr;
		boolean b = (Math.pow((x3 - x1), 2) + Math.pow((y2 - y1), 2)) < rr;
		boolean c = (Math.pow((x2 - x1), 2) + Math.pow((y3 - y1), 2)) < rr;
		boolean d = (Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2)) < rr;
		if (a && b && c && d) {
			System.out.println("YES");
			System.out.println("NO");
			return;
		}

		// 上記以外
		System.out.println("YES");
		System.out.println("YES");
	}
}
