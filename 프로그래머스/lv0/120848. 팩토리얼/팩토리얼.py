def solution(n):
    a = 1
    for i in range(2, 11) :
        a = a * i
        if (a > n) :
            return i - 1
        if (a == n) :
            return i
        
    return 1