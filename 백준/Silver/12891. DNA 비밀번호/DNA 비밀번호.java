import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S =Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
	
		String D = br.readLine();
		st = new StringTokenizer(br.readLine());
		int A_len=Integer.parseInt(st.nextToken());
		int C_len=Integer.parseInt(st.nextToken());
		int G_len=Integer.parseInt(st.nextToken());
		int T_len=Integer.parseInt(st.nextToken());
		
		int result=0;
		int a=0,c=0,g=0,t=0;
		for(int i=0;i<P;i++) {
			switch(D.charAt(i)) {
			case('A'):
				a++;	
				break;
			case('C'):
				c++;

				break;
			case('G'):
				g++;
		
				break;
			case('T'):
				t++;
			break;
			}
		}
		if(a>=A_len&&c>=C_len&&g>=G_len&&t>=T_len) {
			result++;
		}
		int first=0;
		int last=P;
		
		while(last<S) {

			switch(D.charAt(first)) {
			case('A'):a--;break;
			case('C'):c--;break;
			case('G'):g--;break;
			case('T'):t--;break;
			}
			first++;
			
			switch(D.charAt(last)) {
			case('A'):a++;break;
			case('C'):c++;break;
			case('G'):g++;break;
			case('T'):t++;break;
			}
			last++;
			if(a>=A_len&&c>=C_len&&g>=G_len&&t>=T_len) {
				
				result++;
			}
			
			
		}
	
		
		System.out.println(result);
		
	}
	}

