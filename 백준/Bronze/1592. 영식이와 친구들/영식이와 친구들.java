import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		int result=0;
		int current=1;
		
		while(true) {
			array[current]++;
			if(array[current]==M) {
				break;
			}
			
			if(array[current]%2!=0||array[current]==0) {
				current=(current+L)%N;
			}
			else {
				current=(current+(N-L)) %N;
			}
			result++;
		}
		System.out.println(result);

		

	}
	
		
	

}
