def solution(d, budget):
    d = sorted(d)
    ans = 0
    for i in range(len(d)):
        if budget - d[i] >= 0:
            ans += 1
            budget -= d[i]
    return ans