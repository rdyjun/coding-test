def solution(babbling):
    arr = ["aya", "ye", "woo", "ma"]
    c = 0
    answer = 0
    for i in babbling:
        for k in arr:
            c += i.count(k) * len(k)
            n = 0
            for j in range(0, i.count(k)):
                n = i.index(k, n)
                if i.find(k,n - len(k), n) != -1:
                    c -= 1
                n = n + len(k)
        if c == len(i):
            answer += 1
        c = 0
    return answer