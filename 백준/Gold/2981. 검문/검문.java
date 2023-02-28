import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        List<Integer> intArr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        int res = arr.get(1) - arr.get(0);  //28  2, 4, 7, 28

        for(int i = 2; i <= res; i++){
            if(res % i == 0){
                intArr.add(i);
            }
        }

        for(int i = 1; i < n - 1; i++){
            res = arr.get(i + 1) - arr.get(i);
            for(int j = 0; j < intArr.size(); j++){
                if(res % intArr.get(j) != 0){
                    intArr.remove(j);
                    j--;
                }
            }
        }
        for(int i = 0; i < intArr.size(); i++){
            bw.write(intArr.get(i) + " ");
        }
        bw.close();
    }
}
