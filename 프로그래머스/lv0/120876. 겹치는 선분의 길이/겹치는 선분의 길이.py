def solution(lines):
    m = min(lines[0][0], lines[1][0], lines[1][0])
    n = max(lines[0][1], lines[1][1], lines[2][1])
    c = 0
    answer = 0
    for i in range(m, n):
        if (i >= lines[0][0] and i < lines[0][1]):
            c += 1
        if (i >= lines[1][0] and i < lines[1][1]):
            c += 1
        if (i >= lines[2][0] and i < lines[2][1]):
            c += 1
        if (c >= 2) :
            answer += 1
        c = 0
    return answer