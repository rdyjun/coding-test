import java.util.*;
import java.util.stream.*;

class Solution {
    
    private void calc (List<Long> operand, List<String> operator, String op) {
        for (int i = 0; i < operator.size(); i++) {
            if (!operator.get(i).equals(op))
                continue;
            
            switch (op) {
                case "-" :
                    operand.set(i, operand.get(i) - operand.get(i + 1));
                    break;
                case "+" :
                    operand.set(i, operand.get(i) + operand.get(i + 1));
                    break;
                case "*" :
                    operand.set(i, operand.get(i) * operand.get(i + 1));
                    break;
            }
            operand.remove(i + 1);
            operator.remove(i);
            i--;
        }
    }
    public long solution(String expression) {
        String[] opList = new String[]{"-", "+", "*"};
        Set<Long> arr = new HashSet<>();
        
        List<Long> operand = new ArrayList<>(
            Arrays.stream(expression.split("\\W+"))
            .map(Long::parseLong)
            .collect(Collectors.toList())
        );
        
        List<String> operator = new ArrayList<>(
            Arrays.stream(expression.split("\\d+"))
            .collect(Collectors.toList())
        );
        List<String> tmpOperator;
        List<Long> tmpOperand;
        
        operator.remove(0);
        Long num;
        
        for (int i = 0; i < 3; i++) {
            tmpOperator = new ArrayList<>(operator);
            tmpOperand = new ArrayList<>(operand);
            for (int k = i; k < i + 3; k++)
                calc(tmpOperand, tmpOperator, opList[k % 3]);
            num = tmpOperand.get(0);
            if (num < 0)
                num *= -1;
            arr.add(num);
        }
        
        opList = new String[]{"-", "*", "+"};
        
        for (int i = 0; i < 3; i++) {
            tmpOperator = new ArrayList<>(operator);
            tmpOperand = new ArrayList<>(operand);
            for (int k = i; k < i + 3; k++)
                calc(tmpOperand, tmpOperator, opList[k % 3]);
            num = tmpOperand.get(0);
            if (num < 0)
                num *= -1;
            arr.add(num);
        }
        
        return Collections.max(arr);
    }
}