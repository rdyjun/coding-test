import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> types = new HashSet<>();
        // 배열 길이
        int len = gems.length;
        // 타입 중복제거
        for (int i = 0; i < len; i++)
            types.add(gems[i]);
        // 각 타입 map에 저장
        for (String type : types)
            map.put(type, 0);
        // 정답을 담을 배열
        int[] answer = new int[2];
        answer[0] = -1;
        answer[1] = -1;
        // 현재 map에 담고있는 타입 종류 카운트
        int typeCount = 0;
        // 비교중인 left와 right 인덱스
        int right, left = 0;
        String nowType;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            // 현재 젬
            nowType = gems[i];
            // 오른쪽 인덱스 갱신
            right = i;
            // 새로운 인덱스의 젬 추가
            if (!flag)
                map.put(nowType, map.get(nowType) + 1);
            // 추가한 젬이 1이 되었을 때 타입 종류 카운트 추가
            if (!flag && map.get(nowType) == 1)
                typeCount++;
            flag = false;
            // 타입 종류 카운트가 타입 종류와 같으면서, 현재 left, right가 answer보다 작을 때 answer 갱신
            if (typeCount == types.size()) {
                if ((answer[1] == -1 || answer[0] == -1) || answer[1] - answer[0] > right - left) {
                    // answer 업데이트
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                // left를 한 칸 제거
                String leftGem = gems[left];
                int leftGemCount = map.get(leftGem);
                map.put(leftGem, leftGemCount - 1);
                // 제거한 젬의 수가 0이라면 타입 카운트 감소
                if (leftGemCount == 1)
                    typeCount--;
                // left 한 칸 앞으로
                left++;
                // right는 유지
                i--;
                flag = true;
            }
        }
        return answer;
    }
}