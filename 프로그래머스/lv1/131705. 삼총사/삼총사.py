def solution(number):
    l = len(number)
    answer = 0
    for i in range(l - 2):
        for k in range(i + 1, l - 1):
            for j in range(k + 1, l):
                if number[i] + number[k] + number[j] == 0:
                    answer += 1
    return answer