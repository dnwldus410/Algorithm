import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H;
	static int result;
	static int not;
	static int[][][] area;
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이
		// 익은 토마토 1, 익지 않은 토마토 0, 없으면 -1
		area = new int[H][N][M];
		result = -1;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					area[h][i][j] = Integer.parseInt(st.nextToken());
					if (area[h][i][j] == 0) {
						not++;
					}
				}
			}

		}
		if (not == 0) {
			result = 0;
			System.out.println(result);
		} else {
			bfs();

			if (not == 0) {
				System.out.println(result);
			} else {

				System.out.println(-1);
			}
		}

	}

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (area[h][x][y] == 1) {
						queue.add(new int[] { h, x, y });
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			result++;
			for (int s = 0; s < size; s++) {
				int[] pop = queue.poll();
				int pop_x = pop[1];
				int pop_y = pop[2];
				int pop_h = pop[0];
				for (int i = 0; i < 6; i++) {
					int nx = pop_x + dx[i];
					int ny = pop_y + dy[i];
					int nh = pop_h + dh[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && nh >= 0 && nh < H && area[nh][nx][ny] == 0) {
						queue.add(new int[] { nh, nx, ny });
						area[nh][nx][ny] = 1;
						not--;
					}
				}
			}
		}
	}

}
