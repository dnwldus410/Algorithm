import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int P=Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int A_dog=A+B;
		int B_dog=C+D;
		System.out.println(check(P,A_dog,B_dog,B,D));
		System.out.println(check(M,A_dog,B_dog,B,D));
		System.out.println(check(N,A_dog,B_dog,B,D));
		
	}

	public static int check(int num,int adog,int bdog,int b,int d) {
		int result=0;
              if(num%adog<=adog-b&&num%adog!=0) {
            	  result++;
		}
              if(num%bdog<=bdog-d&&num%bdog!=0) {
            	  result++;
              }
           return result;
	}

}
