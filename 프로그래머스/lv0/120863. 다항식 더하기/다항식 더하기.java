class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int n = 0;
        String[] arr = polynomial.split(" ");
        
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i].indexOf("x") >= 0)
                if (arr[i].length() == 1) {
                    x += 1;
                } else
                    x += Integer.parseInt(arr[i].substring(0, arr[i].length() - 1));
            else
                n += Integer.parseInt(arr[i]);
        }
        if (x > 0) {
            if(x == 1)
                answer = "x";
            else 
                answer = x + "x";
            if (n > 0)
                answer += " + " + n;
        } else {
            answer = n + "";
        }
        return answer;
    }
}