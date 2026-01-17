import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] area;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int shark_x, shark_y, result;
	static int shark_size, fish_size;

	static class Fish {
		int x, y, dist;

		Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];

		shark_size = 2;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if (area[i][j] == 9) {
					shark_x = i;
					shark_y = j;
					area[i][j] = 0;

				}
			}
		}
		while (true) {
			Fish f = FishCheck();
			if (f == null) {
				break;
			}
			shark_x = f.x;
			shark_y = f.y;
			result += f.dist;
			area[f.x][f.y] = 0;

			fish_size++;
			if (shark_size == fish_size) {
				shark_size++;
				fish_size = 0;
			}
		}
		System.out.println(result);
	}

	public static Fish FishCheck() {
		int[][] check = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check[i][j] = -1;
			}
		}
		check[shark_x][shark_y] = 0;
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(shark_x, shark_y));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && check[nx][ny] == -1 && area[nx][ny] <= shark_size) {
					check[nx][ny] = check[cur.x][cur.y] + 1;
					queue.add(new Node(nx, ny));
				}
			}

		}
		Fish target = null;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (area[i][j] >= 1 && area[i][j] < shark_size && check[i][j] != -1) {
					int d = check[i][j];
					if (target == null || d < target.dist || (d == target.dist && i < target.x)
							|| (d == target.dist && i == target.x && j < target.y)) {
						target = new Fish(i, j, d);
					}

				}
			}
		}
		return target;

	}
}
