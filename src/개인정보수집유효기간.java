import java.util.ArrayList;
import java.util.Date;

public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        ArrayList<Integer> answer = new ArrayList<>();
        int y, m, d;


        for (int i = 0; i < privacies.length; i++) {
            y = Integer.parseInt(privacies[i].substring(0,4));
            m = Integer.parseInt(privacies[i].substring(5, 7));
            d = Integer.parseInt(privacies[i].substring(8, 10));

            for(int k = 0; k < terms.length; k++) {
                if(privacies[i].charAt(11) == terms[k].charAt(0)){
                    m += Integer.parseInt(terms[k].substring(terms[k].indexOf(" ") + 1, terms[k].length()));
                    if ( m > 12 ) {
                        m %= 12;
                        y++;
                    }

                }
            }
        }

    }
}
