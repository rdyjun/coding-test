def solution(a, b):
    n = a % 2 + b % 2
    if (n == 2) :
        answer = a * a + b * b
    elif (n == 1) :
        answer = 2 * (a + b)
    else :
        answer = abs(a - b)
    return answer