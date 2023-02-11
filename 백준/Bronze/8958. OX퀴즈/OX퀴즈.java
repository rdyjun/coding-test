import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String st;
        int c = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            st = br.readLine();
            for(int k = 0; k < st.length(); k++){
                if(st.charAt(k) == 'O'){
                    ++c;
                    sum += c;
                } else {
                    c = 0;
                }
            }
            bw.write(sum + "\n");
            c = 0;
            sum = 0;
        }


        bw.close();
    }
}