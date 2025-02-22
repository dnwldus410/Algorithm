import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] area;
	static int[][] pipe;
   static Queue<int[]> queue;
   static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		area = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		queue=new LinkedList();
		pipe = new int[N][N];
		pipe[0][0] = pipe[0][1] = 1;  //1가로,2세로,3대각
		queue.add(new int[] {0,1,1});
		count=0;
		
		if(area[N-1][N-1]==1) {
			
		}
		else {
			bfs(queue);
		}
		
		
		System.out.println(count);
		
	}
	public static void bfs(Queue<int[]> queue) {
		
		while(!queue.isEmpty()) {
			int[] pos=queue.poll();			
			int x=pos[0],y=pos[1],z=pos[2];
			
			if(x==N-1&&y==N-1) {
				count++;
			}
			
			if(z==1) {
				if(y+1<N&&area[x][y+1]==0) {
					queue.add(new int[] {x,y+1,1});
				}
				if(x+1<N&& y+1<N&&area[x+1][y+1]==0&&area[x][y+1]==0&&area[x+1][y]==0) {
					queue.add(new int[] {x+1,y+1,3});
				}
			}
			else if(z==2) {
				if(x+1<N&&area[x+1][y]==0) {
					queue.add(new int[] {x+1,y,2});
				}
				if(x+1<N&& y+1<N&&area[x+1][y+1]==0&&area[x][y+1]==0&&area[x+1][y]==0) {
					queue.add(new int[] {x+1,y+1,3});
				}
				
			}
			else if(z==3) {
				if(x+1<N&&area[x+1][y]==0) {
					queue.add(new int[] {x+1,y,2});
				}
				if(y+1<N&&area[x][y+1]==0) {
					queue.add(new int[] {x,y+1,1});
				}
				if(x+1<N&& y+1<N&&area[x+1][y+1]==0&&area[x][y+1]==0&&area[x+1][y]==0) {
					queue.add(new int[] {x+1,y+1,3});
				}
			}
			
		}
	}
}
