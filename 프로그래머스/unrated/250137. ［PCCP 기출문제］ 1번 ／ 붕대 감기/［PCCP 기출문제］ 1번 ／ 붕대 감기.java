class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int minTime = attacks[0][0];
        int maxTime = attacks[attacks.length - 1][0];
        int attackIndex = 0;
        int healDuration = 0;
        int nowHealth = health;
        for (int i = minTime; i <= maxTime; i++) {
            if (i == attacks[attackIndex][0]) {
                nowHealth -= attacks[attackIndex][1];
                attackIndex++;
                healDuration = 0;
                if (nowHealth <= 0)
                    return -1;
                continue;
            }
            nowHealth += bandage[1];
            healDuration++;
            if (healDuration >= bandage[0])
                nowHealth += bandage[2];
            if (nowHealth > health)
                nowHealth = health;
        }
        return nowHealth;
    }
}