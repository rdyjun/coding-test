class Solution {
    public int solution(int[][] triangle) {
        int nodeDepth = triangle.length;
        for (int i = 0; i < nodeDepth - 1; i++) {
            compareParent(triangle[i], triangle[i + 1]);
        }
        int max = 0;
        for (int i = 0; i < triangle[nodeDepth - 1].length; i++) {
            if (max < triangle[nodeDepth - 1][i])
                max = triangle[nodeDepth - 1][i];
        }
        return max;
    }
    private void compareParent (int[] parent, int[] child) {
        int childElementCount = child.length;
        for (int childElement = 0; childElement < childElementCount; childElement++) {
            if (childElement == 0) {
                child[childElement] += parent[childElement];
                continue;
            }
            if (childElement == childElementCount - 1) {
                child[childElement] += parent[childElement - 1];
                continue;
            }
            if (parent[childElement - 1] < parent[childElement]) {
                child[childElement] += parent[childElement];
                continue;
            }
            if (parent[childElement - 1] > parent[childElement]) {
                child[childElement] += parent[childElement - 1];
                continue;
            }
        }
    }
}