import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
static int count;
static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
        br.close();
		sb=new StringBuilder();
		hanoi(N,1,2,3);
		System.out.println(count);
		System.out.println(sb);
	}
public static void hanoi(int N,int from,int temp,int to) {
	
	if(N==0)return;
	hanoi(N-1,from,to,temp);
	sb.append(from).append(" ").append(to).append("\n");
	count++;
	hanoi(N-1,temp,from,to);
}
}
