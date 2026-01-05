import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N];

		select(0);
		System.out.print(sb);
	}

	public static void select(int depth) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i + " ");

			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[depth]) {
				visited[depth] = true;
				arr[depth] = i + 1;
				select(depth + 1);
				visited[depth] = false;
			}

		}
	}
}
