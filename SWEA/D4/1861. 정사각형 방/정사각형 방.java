import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int move, num, result;
	static boolean[][] visited;
	static int[][] area;
	static int[][] result_area;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= x; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			move = 0;
			result = N * N;
			area = new int[N][N];
			result_area = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (area[i][j] == N * N) {
						continue;
					}
					visited = new boolean[N][N];
					visited[i][j] = true;
					dfs(i, j, 1);
					result_area[i][j] = num;
					move = Math.max(move, num);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (result_area[i][j] == move) {
						result = Math.min(result, area[i][j]);

					}

				}
			}
			System.out.println("#" + test + " " + result + " " + move);
		}
	}

	public static void dfs(int x, int y, int count) {
		num = count;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && area[x][y] + 1 == area[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, count + 1);
			}

		}
	}

}
