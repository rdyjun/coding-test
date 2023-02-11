import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = 0;
        int[] arr = new int[10];
        loop:
        for(int i = 0; i < 10; i++){
            arr[i] = Integer.parseInt(br.readLine()) % 42;
            for(int k = 0; k < i; k++){
                if(arr[i] == arr[k])
                    continue loop;
            }
            c++;
        }
        bw.write(c + "\n");
        bw.close();
    }
}