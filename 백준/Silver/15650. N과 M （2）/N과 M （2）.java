import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N];

		select(0, 0);
	}

	public static void select(int depth, int start) {
		if (depth == M) {
			for (int i : arr) {
				System.out.print(i + " ");

			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			if (depth == 0) {
				arr[depth] = i + 1;
				select(depth + 1, start + 1);
			} else {
				if (arr[depth - 1] <= i) {
					arr[depth] = i + 1;
					select(depth + 1, start + 1);
				}
			}

		}
	}
}
