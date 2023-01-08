import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        String s = "()()";

        int[] arr = new int[s.length()];
        int a, b;  // (와 )의 위치

        //arr에 s배열을 숫자로 넣기
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                arr[i] = 0;
            else
                arr[i] = 1;
        }

        if (s.charAt(0) == ')' || s.length() % 2 == 1 || s.charAt(s.length() - 1) == '(')
            System.out.println("false");

        for (int i = 0; i < s.length(); i++){

        }


        System.out.println("true");
    }   // ((( )( )))
}