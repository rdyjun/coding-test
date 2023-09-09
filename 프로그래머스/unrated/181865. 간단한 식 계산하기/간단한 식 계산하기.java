class Solution {
    public int solution(String binomial) {
        int spaceIndex = binomial.indexOf(" ") + 1;
        int operation1 = Integer.parseInt(binomial.substring(0, spaceIndex - 1));
        int operation2 = Integer.parseInt(binomial.substring(spaceIndex + 2));
        char operator = binomial.substring(spaceIndex, spaceIndex + 1)
            .charAt(0);
        switch (operator) {
            case '+':
                return operation1 + operation2;
            case '-':
                return operation1 - operation2;
            case '*':
                return operation1 * operation2;
            case '/':
                return operation1 / operation2;
                
        }
        return -1;
    }
}