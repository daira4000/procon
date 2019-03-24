import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		Pattern pattern = Pattern.compile("[ACGT]+");
		Matcher matcher = pattern.matcher(S);
		int ret = 0;
		while (matcher.find()) {
			int length = matcher.group().length();
			ret = Math.max(ret, length);
		}
		System.out.println(ret);
	}
}
