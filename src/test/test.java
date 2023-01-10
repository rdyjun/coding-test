package test;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        int[][] caseCount = new int[][]{{4, 4, 2, 4}};
        int[][] users = new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = new int[]{1300, 1500, 1600, 4900};
        int[] plus = new int[caseCount.length];
        int[] sales = new int[caseCount.length];

        for (int i = 0; i < caseCount.length; i++){  // 4424
            user:
            for(int k = 0; k < users.length; k++){   // k = 0
                int a = 0;
                emoticons:
                for(int o = 0; o < emoticons.length; o++){  // o = 3
                    if(users[k][0] <= caseCount[i][o] * 10){  // users[0][0] = 40 <= 40
                        a += emoticons[o] * caseCount[i][o] * 10 / 100;  // a = 520 + 600 + 1960
                        if(a >= users[k][1]){  // 520 + 600 >= 2900 false
                            plus[i] += 1;
                            continue user;
                        }
                    }
                    if (o == emoticons.length - 1) {
                        sales[i] += a;
                        break;
                    }
                }
            }
        }
    }
}
