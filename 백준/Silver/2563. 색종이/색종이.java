import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[][] white = new boolean[100][100];
		List <Integer> list = new ArrayList();
		int[][] dis = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			dis[i][0] = x;
			dis[i][1] = y;

		}
		for(int i=0;i<N;i++) {
			for(int x=dis[i][0];x<dis[i][0]+10;x++) {
				for(int y=dis[i][1];y<dis[i][1]+10;y++) {
					if(white[x][y]==true) {
						list.add(x);
						list.add(y);
					}
					else {
						white[x][y]=true;
					}
					
				}
			}

		}


		


		
		System.out.println(N * 100 - list.size()/2);

	}

}
