import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static String WordReverse(String word) {
		StringBuilder sb = new StringBuilder(word);
		return sb.reverse().toString();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"> <",true);
		List<String> word = new ArrayList();
		while(st.hasMoreTokens()) {
			word.add(st.nextToken());
		}
		boolean check=false;
		for(int i=0;i<word.size();i++) {
			if(i-1==-1&&!word.get(i).contains("<")) {
				word.set(i,WordReverse(word.get(i)));
			}
			else if(word.get(i).contains("<")&&!check) {
				check=true;
			}
			else if(word.get(i).contains(">")&&check&&i+1<word.size()) {
				word.set(i+1,WordReverse(word.get(i+1)));
				check=false;
			}
			else if(word.get(i).isBlank()&&!check&&i+1<word.size()) {
				word.set(i+1,WordReverse(word.get(i+1)));
			}
		}
		for(String a : word) {
			System.out.print(a);
		}
		System.out.println("");
		
	}

}
