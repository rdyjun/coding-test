import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer input = new StringTokenizer(br.readLine());
        
        int range = Integer.parseInt(input.nextToken());
        Stack<Integer> stack = new Stack<>();
        
        while (range-- > 0) {
            input = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(input.nextToken());
            
            switch (num){
                case 1:
                    stack.add(Integer.parseInt(input.nextToken()));
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        bw.write("-1\n");
                        break;
                    }
                    
                    bw.write(stack.pop() + "\n");
                    break;
                case 3:
                    bw.write(stack.size() + "\n");
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        bw.write("1\n");
                        break;
                    }
                    
                    bw.write("0\n");
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        bw.write("-1\n");
                        break;
                    }
                    
                    bw.write(stack.peek() + "\n");
            }
        }
        
        bw.close();
        br.close();
    }
}
