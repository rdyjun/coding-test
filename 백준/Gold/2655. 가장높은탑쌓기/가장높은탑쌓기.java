import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;

public class Main{
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 최대 100개
        int brickCount = Integer.parseInt(st.nextToken());

        // 벽돌 목록
        List<Integer[]> brickList = new ArrayList<>();

        // 벽돌 목록 저장
        for (int brickIndex = 0; brickIndex < brickCount; brickIndex++) {
            st = new StringTokenizer(br.readLine());

            int width = Integer.parseInt(st.nextToken());  // 밑변
            int height = Integer.parseInt(st.nextToken()); // 높이
            int weight = Integer.parseInt(st.nextToken()); // 무게
            
            Integer[] brickInfo = new Integer[]{width, height, weight};

            brickList.add(brickInfo);
        }

        // 무게기준으로 내림 차순했을 때 각 순서 리스트
        // 2 4 1 3 5
        List<Integer> indexList = IntStream.range(0, brickCount)
            .boxed()
            .sorted((a, b) -> brickList.get(b)[2] - brickList.get(a)[2])
            .collect(Collectors.toList());

        // 각 인덱스별 최대 값 (indexList 기준)
        int[] dp = new int[brickCount];
        // 각 인덱스별 벽돌 사용 수
        int[] dp2 = new int[brickCount];
        for (int i = 0; i < brickCount; i++) {
            int currentIndex = indexList.get(i);

            // 뒤로 가면서 낄 수 있는 벽돌 찾기
            for (int k = i - 1; k >= 0; k--) {
                int prevIndex = indexList.get(k);

                // 이 벽돌이 현재 벽돌보다 큰가?
                if (brickList.get(currentIndex)[0] < brickList.get(prevIndex)[0]
                   && dp[k] > dp[i]) {
                    dp[i] = dp[k];
                    dp2[i] = dp2[k];
                }
            }

            // 현재 값 더하기
            dp[i] += brickList.get(currentIndex)[1];
            // 현재 값을 사용했다고 표시
            dp2[i]++;
        }

        int maxValue = 0;
        int maxValuesIndex = 0;
        for (int i = 0; i < brickCount; i++) {
            if (maxValue < dp[i]) {
                maxValue = dp[i];
                maxValuesIndex = i;
            }
        }

        // 가장 높은 경우에 사용된 블럭 수
        System.out.println(dp2[maxValuesIndex]);

        // 기준점
        Integer[] current = brickList.get(indexList.get(maxValuesIndex));

        // 뒤로 돌아가면서 기준을 충족하는 요소 찾기
        for (int i = maxValuesIndex; i >= 0; i--) {
            int targetIndex = indexList.get(i);
            Integer[] target = brickList.get(targetIndex);

            // 기준 벽돌보다 큰 벽돌이면서 dp에 기록된 높이와 일치하는가?
            if (current[0] <= target[0] && current[2] <= target[2]
               && dp[i] == maxValue) {
                System.out.println(targetIndex + 1);
                current = target;
                maxValue -= target[1];
            }
        }
    }
}
