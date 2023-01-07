//import java.util.Stack;
//
//public class 올바른괄호 {
//    public static boolean main(String[] args) {
//        String s = "(())()";
//
//        char c = s.charAt(0);
//
//        if (c == ')' || s.length() % 2 == 1 || s.charAt(s.length() - 1) == '(')
//            return false;
//
//        Stack<Character> a = new Stack<>();
//        a.push('(');
//
//        for (int i = 1; i < a.size(); i++) {
//            if(a.get(i - 1) == '(' && s.charAt(i) == ')'){
//
//            }
//        }
//
//        System.out.println(a.replaceAll("\\(.*\\)", ""));
//    }
//}