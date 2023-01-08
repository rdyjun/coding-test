package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 올바른괄호 {
    public static void main(String[] args) {
        String s = "())(()";
        int a = 0;
        for(char i : s.toCharArray()){
            a += i == '(' ? 1 : -1;
            if (a < 0)
                System.out.println(false); // return false
        }
        System.out.println(a == 0);  //return
    }
}

// int[] 배열
//String s = "(())()";
//
//    int[] arr = new int[s.length()];
//    int k;
//
////arr에 s배열을 숫자로 넣기
//        for(int i = 0; i < s.length(); i++){
//        if(s.charAt(i) == '(')
//        arr[i] = 0;
//        else
//        arr[i] = 1;
//        }
//
//        if (s.charAt(0) == ')' || s.length() % 2 == 1 || s.charAt(s.length() - 1) == '(')
//        System.out.println("false - 1");
//
//        loop:
//        for (int i = 0; i < s.length(); i++){
//        if(arr[i] == 0) {
//        arr[i] = -1;
//        //짝꿍 찾기
//        for(k = i + 1; k < s.length(); k++){
//        if(arr[k] == 1) {
//        arr[k] = -1;
//        if (k == s.length() - 1){
//        break loop;
//        } else
//        continue loop;
//        }
//        }
//        System.out.println("false - 2");
//        //arr[i]가 (가 먼저 나오지 않고 )가 먼저 나오면 false
//        } else if (arr[i] == 1)
//        System.out.println("false - 3");
//        }
//        System.out.println(Arrays.asList(arr).indexOf(0) == -1);

//ArrayList 사용
//String s = "())(()";
//
//        if (s.charAt(0) == ')' || s.length() % 2 == 1 || s.charAt(s.length() - 1) == '(') {
//                System.out.println("false - 1");
//                return;
//                }
//
//                ArrayList<String> arr = new ArrayList<>(Arrays.asList(s.split("")));
//
//        int idx, i;
//
//        while (arr.size() > 0){
//        i = 0;
//        if(arr.get(i).equals("(")) {
//        arr.remove(i);
//        //짝꿍 찾기
//        idx = arr.indexOf(")");
//        if (idx != -1){
//        arr.remove(idx);
//        if(idx - 1 == arr.size() - 1){
//        break;
//        }
//        } else {
//        System.out.println(false);
//        return;
//        }
//        //arr.get(i)에 "("가 먼저 나오지 않고 ")"가 먼저 나오면 false
//        } else if (arr.get(i).equals(")")) {
//        System.out.println("false - 3");
//        return;
//        }
//        }
//        System.out.println(arr.size() == 0);