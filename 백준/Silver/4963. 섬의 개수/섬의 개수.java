import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, -1, 1 };
	static int w;
	static int h;
	static int[][] area;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
	st = new StringTokenizer(br.readLine());
	
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		if (w == 0 && h == 0) {
   break;
		} else {

			Queue<int[]> queue = new LinkedList();
			area = new int[h][w];
			visited = new boolean[h][w];
			for (int x = 0; x < h; x++) {
				st = new StringTokenizer(br.readLine());
				for (int y = 0; y < w; y++) {
					area[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			int island = 0;
			for (int x = 0; x < h; x++) {
				for (int y = 0; y < w; y++) {
					if (area[x][y] == 1 && !visited[x][y]) {
						visited[x][y] = true;
						queue.add(new int[] { x, y });
						island += checking(queue);

					}
				}
			}

			System.out.println(island);

		}
	}
	}
	public static int checking(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0], y = pos[1];
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < h && ny >= 0 && ny < w && area[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}

			}

		}
		return 1;
	}

}
