import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//블랙잭
public class Main {

	public static void main(String[] args) throws IOException{
	// TODO Auto-generated method stub


	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	int N=Integer.parseInt(st.nextToken());
	int M=Integer.parseInt(st.nextToken());
	
	int[] array = new int[N];
	st = new StringTokenizer(br.readLine()," ");
	for(int i=0;i<N;i++) {
		array[i]=Integer.parseInt(st.nextToken());
		
	}
	int result=0;
	for(int i=0;i<N-2;i++) {
		for(int j=i+1;j<N-1;j++) {
			for(int k=j+1;k<N;k++) {
				int sum = array[i]+array[j]+array[k];
				if(sum<=M) {
					result=Math.max(result, sum);
				}
				else {
					continue;
				}
			}
		}
	}
	System.out.println(result);
	
}

}


