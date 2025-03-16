import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		int standard = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			standard = Math.max(tree[i], standard);
		}

		System.out.println(binarySearch(0, standard));
	}

	public static long binarySearch(int left, int right) {

		long result = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			long wood = getWood(mid);

			if (wood >= M) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;

	}

	public static long getWood(int height) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (tree[i] > height) {
				sum += tree[i] - height;
			}
		}
		return sum;
	}

}
