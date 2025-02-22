import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> person = new ArrayList();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			person.add(Integer.parseInt(st.nextToken()));
		}
		
		person.sort(Comparator.naturalOrder());
		int result=0;
		int maxnum=N;
		for(int i=0;i<N;i++) {
			result+= person.get(i)*maxnum;
			maxnum--;
		
		}
		System.out.println(result);
	}

}
