def solution(l, r):
    answer = []
    i = 1
    n = 5
    while n <= r:
        if n >= l:
            answer.append(5 * int(bin(i)[2:]))
        i += 1
        n = 5 * int(bin(i)[2:])
    if not len(answer):
        answer.append(-1)
    return answer