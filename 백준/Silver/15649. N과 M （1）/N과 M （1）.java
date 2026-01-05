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

		select(0);
	}

	public static void select(int depth) {
		if (depth == M) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				select(depth + 1);

				visited[i] = false;
			}
		}
	}
}
