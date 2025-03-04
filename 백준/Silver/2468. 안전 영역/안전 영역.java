import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, min, max, sum, result;
	static int[][] area;
	static boolean[][] visited;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		sum = 0;
		result = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, area[i][j]);
				max = Math.max(max, area[i][j]);
			}
		}
		for (int i = min; i <= max; i++) {
			visited = new boolean[N][N];
			sum = 0;
			color(i);
			result = Math.max(sum, result);
		}

		System.out.println(result);
	}

	public static void color(int i) {

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (area[x][y] <= i) {
					visited[x][y] = true;
				}
			}

		}

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited[x][y]) {
					visited[x][y] = true;
					bfs(x, y);

				}

			}
		}

	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList();
		sum++;

		queue.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int a = pos[0], b = pos[1];
			for (int i = 0; i < 4; i++) {
				int nx = a + dx[i];
				int ny = b + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}

			}
		}

	}

}
