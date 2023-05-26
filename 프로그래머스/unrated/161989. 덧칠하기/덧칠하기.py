def solution(n, m, section):
    answer = 0
    now = 0
    for i in section:
        if now <= i:
            now = i + m
            answer += 1
        
    return answer