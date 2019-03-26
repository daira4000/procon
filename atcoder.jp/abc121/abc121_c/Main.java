import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		ArrayList<Pair<Long, Long>> ab = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ab.add(new Pair<Long, Long>(in.nextLong(), in.nextLong()));
		}
		ab.sort((a, b) -> a.compareTo(b));

		long total = 0;
		for (Pair<Long, Long> pair : ab) {
			if (pair.value >= M) {
				total += pair.key * M;
				break;
			}
			total += pair.key * pair.value;
			M -= pair.value;
		}
		System.out.println(total);
	}

	private static class Pair<K extends Comparable<K>, V extends Comparable<V>>
			implements Map.Entry<K, V>, Comparable<Pair<K, V>> {

		private K key;
		private V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V v = this.value;
			this.value = value;
			return v;
		}

		@Override
		public String toString() {
			return "[" + key.toString() + ", " + value.toString() + "]";
		}

		@Override
		public int compareTo(Pair<K, V> o) {
			int c1 = this.key.compareTo(o.key);
			if (c1 != 0) {
				return c1;
			}
			return this.value.compareTo(o.value);
		}
	}
}
