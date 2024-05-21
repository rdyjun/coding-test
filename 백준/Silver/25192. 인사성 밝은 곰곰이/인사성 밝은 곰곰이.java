import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		Set<String> name = new HashSet<>();
		int emoticonCount = 0;

		for (int i = 0; i < n; i++) {
			String user = reader.readLine();
			if (!user.equals("ENTER")) {
				name.add(user);
				continue;
			}

			emoticonCount += name.size();
			name.clear();
		}

		emoticonCount += name.size();

		writer.write(emoticonCount + "");

		writer.flush();
		writer.close();
		reader.close();
    }

}
