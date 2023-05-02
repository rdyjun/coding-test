def solution(n):
    answer = 0
    for i in range(1, n + 1) :
        n = 0
        for k in range(1, i + 2) :
            if(n >= 3) :
                answer = answer + 1
                print(k)
                break
            if(i % k == 0) :
                n = n + 1
    return answer