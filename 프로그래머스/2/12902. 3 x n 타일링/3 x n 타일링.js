function solution(n) {
    if (n % 2 == 1) {
        return 0;
    }
    
    if (n == 2) {
        return 3;
    }
    
    if (n == 4) {
        return 11;
    }
    
    let arr = [3, 11];
    for (var i = 6; i <= n; i += 2) {
        arr[i / 2 - 1] = (arr[i / 2 - 2] * 3 + 2) % 1000000007;
        
        for (var j = i - 4; j >= 2; j -= 2) {
            arr[i / 2 - 1] = (arr[i / 2 - 1] + arr[j / 2 - 1] * 2) % 1000000007;
        }
    }
    
    return arr[n / 2 - 1] % 1000000007;
}