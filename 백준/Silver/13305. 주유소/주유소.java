import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
int[] road = new int[N-1];
int[] gas = new int[N];
int result=0;
StringTokenizer st = new StringTokenizer(br.readLine());
for(int i=0;i<N-1;i++){
    road[i] = Integer.parseInt(st.nextToken());
}
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            gas[i] = Integer.parseInt(st.nextToken());
        }
        int cnt=1;
       result+=gas[0]*road[0];
        for(int i=0;i<N-2;i++){
            if(gas[i]>=gas[i+1]){

                result+=gas[i+1]*road[cnt];
            }
            else{
                result+=gas[i]*road[cnt];
            }
            cnt++;
        }
        System.out.println(result);
    }
}