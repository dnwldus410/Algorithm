import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cake = new int[L];
		int[][] person = new int[N][3];
		int before = 0;
		int After = 0;

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				person[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (person[i][1] - person[i][0] > max) {
				before = i+1;
				max = person[i][1] - person[i][0];
			}

		}
		
		for (int i = 0; i < N; i++) {
			for (int j = person[i][0] - 1; j < person[i][1]; j++) {
				if(cake[j]==0) {
					cake[j]=i+1;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for (int j = 0; j < L; j++) {
				if(i+1==cake[j]) {
					person[i][2]+=1;
				}
			}
		}
		max = 0;
		for(int i=0;i<N;i++) {
			if (person[i][2] >= max) {
				max = person[i][2];
			}
		}
		for(int i=0;i<N;i++) {
			if (person[i][2] == max) {
				After=i+1;
				break;
			}
		}
			
		System.out.println(before);
		System.out.println(After);
		}
	
	}


