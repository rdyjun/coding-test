package programmers;

import java.util.ArrayList;

public class 방문길이 {
    int answer = 0;
    ArrayList<String> arr = new ArrayList<>();
    public void compare (float x, float y) {
        if (!arr.contains(String.valueOf(x) + y)){
            ++answer;
            arr.add(String.valueOf(x) + y);
        }
    }
    public int solution(String dirs) {
        int x = 0;
        int y = 0;

        for(int i = 0; i < dirs.length(); i++){
            char dChar = dirs.charAt(i);

            switch (dChar) {
                case 'U':
                    if(y == 5)
                        break;
                    ++y;
                    compare(x, (float)(y - 0.5));
                    break;
                case 'D':
                    if(y == -5)
                        break;
                    --y;
                    compare(x, (float)(y + 0.5));
                    break;
                case 'L':
                    if(x == -5)
                        break;
                    --x;
                    compare((float)(x + 0.5), y);
                    break;
                case 'R':
                    if(x == 5)
                        break;
                    ++x;
                    compare((float)(x - 0.5), y);
                    break;
            }
        }
        for(String i : arr){
            System.out.println(i);
        }
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) {
        방문길이 s = new 방문길이();
//        s.solution("ULURRDLLU");
        s.solution("LULLLLLLU");
//        s.solution("UUUUUDDDDDDDDDD");
    }
}
