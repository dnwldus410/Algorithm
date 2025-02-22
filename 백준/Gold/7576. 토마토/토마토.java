import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[][] tomato;
	static boolean[][] visitied;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new LinkedList();

		tomato = new int[N][M];
		visitied = new boolean[N][M];

		int days = 0;
		int ripedtomato = 0;
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < M; y++) {
				tomato[x][y] = Integer.parseInt(st.nextToken());
				if (tomato[x][y] == 0) {
					ripedtomato++;
				}
				if (tomato[x][y] == 1) {
					visitied[x][y] = true;
					queue.add(new int[] { x, y, 0 });
					
					
				}
			}
		}
		if (ripedtomato == 0) {
			System.out.println(ripedtomato);
		} else {
			days = checking(queue);
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if(tomato[x][y]==0) {
						days=-1;
						break;
					}				
				}				
			}
			System.out.println(days);
		}

	}

	public static int checking(Queue<int[]> queue) {
		int day = 0;

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0], y = pos[1], days = pos[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
		 
	
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && tomato[nx][ny] == 0 && !visitied[nx][ny]) {
					queue.add(new int[] { nx, ny, days + 1 });
					visitied[nx][ny] = true;
					tomato[nx][ny] = 1;
					
				
				}
			}
			day = Math.max(day, days);

		}
		return day;

	}

}
