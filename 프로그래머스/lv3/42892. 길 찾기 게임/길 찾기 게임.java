import java.util.*;
import java.lang.*;

class Solution {
    private Node[] allNode;
    private int nodeLen;
    private int[][] node;
    private List<Integer> arr = new ArrayList<>();

    private void createNode (int[] root, int n, int leftLimit, int rightLimit) {
        int minRow = -1;
        int x, y;
        for (int i = n + 1; i < nodeLen; i++) {
            x = allNode[i].getX();
            y = allNode[i].getY();

            if (minRow == -1 && y < root[0])
                minRow = y;

            if (minRow == -1 || minRow < y)
                continue;

            if (minRow > y)
                break;

            if (x < root[1] && leftLimit < x) {
                this.node[n][0] = i;
                createNode(new int[]{y, x}, i, leftLimit, root[1]);
                break;
            }
        }

        if (minRow == -1)
            return;

        for (int i = n + 1; i < nodeLen; i++) {
            x = allNode[i].getX();
            y = allNode[i].getY();

            if (minRow < y)
                continue;

            if (minRow > y)
                break;

            if (x > root[1] && rightLimit > x) {
                this.node[n][1] = i;
                createNode(new int[]{y, x}, i, root[1], rightLimit);
                break;
            }
        }
    }

    private void before (int root) {
        arr.add(allNode[root].getN());
        if (this.node[root][0] != 0)
            before(this.node[root][0]);

        if (this.node[root][1] != 0)
            before(this.node[root][1]);

    }
    private void after (int root) {

        if (this.node[root][0] != 0)
            after(this.node[root][0]);

        if (this.node[root][1] != 0)
            after(this.node[root][1]);

        arr.add(allNode[root].getN());
    }

    public int[][] solution(int[][] nodeinfo) {
        this.nodeLen = nodeinfo.length;
        this.allNode = new Node[nodeLen];
        this.node = new int[nodeLen][2];
        int[][] answer = new int[2][nodeLen];

        for (int i = 0; i < nodeLen; i++)
            this.allNode[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);

        Arrays.sort(this.allNode, Comparator.comparingInt((Node v) -> v.getX()));
        Arrays.sort(this.allNode, Comparator.comparingInt((Node v) -> v.getY()).reversed());

        int maxX = Arrays.stream(this.allNode)
                .map(Node::getX)
                .max(Integer::compare)
                .orElse(0);

        int top = allNode[0].getY();
        int left = allNode[0].getX();

        createNode (new int[]{top, left}, 0, -1, maxX + 1);
        before (0);
        answer[0] = arr.stream()
                        .mapToInt(v -> v)
                        .toArray();
        arr = new ArrayList<>();
        after(0);
        answer[1] = arr.stream()
                .mapToInt(v -> v)
                .toArray();

        return answer;
    }
}

class Node {
    private int x;
    private int y;
    private int n;

    public Node (int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }
    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

    public int getN () {
        return this.n;
    }
}