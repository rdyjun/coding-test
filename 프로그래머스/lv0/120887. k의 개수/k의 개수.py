def solution(i, j, k):
    answer = 0
    for i in range(i, j + 1) :
        c = str(i).count(str(k))
        if (c >= 0) :
            answer += c
    return answer