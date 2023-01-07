import java.util.*;

public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        //년도, 월, 일 숫자로 변환 후 비교 ex) 20220101 > 20210101
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2001.01.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] answer;
        int todayInt = Integer.parseInt(today.replaceAll("\\.", ""));
        int y, m, d;

        ArrayList<Integer> arr = new ArrayList<Integer>();


        for (int i = 0; i < privacies.length; i++) {
            y = Integer.parseInt(privacies[i].substring(0,4));
            m = Integer.parseInt(privacies[i].substring(5, 7));
            d = Integer.parseInt(privacies[i].substring(8, 10));
            for(int k = 0; k < terms.length; k++) {
                if(privacies[i].charAt(11) == terms[k].charAt(0)){
                    m += Integer.parseInt(terms[k].substring(terms[k].indexOf(" ") + 1));
                    y += (m - 1) / 12;
                    m = ((m - 1) % 12) + 1;

                    if(Integer.parseInt(y + (m < 10 ? "0" : "") + m + (d < 10 ? "0" : "") + d) <= todayInt) {
                        arr.add(i + 1);
                    }
                    break;
                }
            }
        }
        answer = new int[arr.size()];
        for(int i = 0 ; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }


        System.out.println("출력");
        for (int i : arr){
            System.out.println(i);
        }
    }
}
// 년도, 월, 일을 전부 일자로 변경
//import java.util.*;
//
//class Solution {
//    public int[] solution(String today, String[] terms, String[] privacies) {
//        int[] answer;
//        int todayInt = Integer.parseInt(today.replaceAll("\\.", ""));
//        int ymd;
//        int todayDate = 0;
//
//        todayDate += Integer.parseInt(today.substring(0,4)) * 12 * 28;
//        todayDate += Integer.parseInt(today.substring(5,7)) * 28;
//        todayDate += Integer.parseInt(today.substring(8,10));
//
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//
//
//        for (int i = 0; i < privacies.length; i++) {
//            ymd = Integer.parseInt(privacies[i].substring(0,4)) * 12 * 28;
//            ymd += Integer.parseInt(privacies[i].substring(5, 7)) * 28;
//            ymd += Integer.parseInt(privacies[i].substring(8, 10));
//
//            for(int k = 0; k < terms.length; k++) {
//                if(privacies[i].charAt(11) == terms[k].charAt(0)){
//                    ymd += Integer.parseInt(terms[k].substring(terms[k].indexOf(" ") + 1)) * 28;
//
//                    if(ymd <= todayDate) {
//                        arr.add(i + 1);
//                    }
//                }
//            }
//        }
//        answer = new int[arr.size()];
//        for(int i = 0 ; i < arr.size(); i++) {
//            answer[i] = arr.get(i);
//        }
//
//        return answer;
//    }
//}