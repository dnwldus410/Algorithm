import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		if (num.contains("dz=")) {
			num = num.replace("dz=", "a");
		}
		if (num.contains("c=")) {
			num = num.replace("c=", "a");
		}
		if (num.contains("c-")) {
			num = num.replace("c-", "a");
		}
		if (num.contains("d-")) {
			num = num.replace("d-", "a");
		}
		if (num.contains("lj")) {
			num = num.replace("lj", "a");
		}
		if (num.contains("nj")) {
			num = num.replace("nj", "a");
		}
		if (num.contains("s=")) {
			num = num.replace("s=", "a");

		}
		if (num.contains("z=")) {
			num = num.replace("z=", "a");
		}

		System.out.println(num.length());

	}

}
