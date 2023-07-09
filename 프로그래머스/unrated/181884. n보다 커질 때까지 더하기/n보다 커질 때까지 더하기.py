def solution(numbers, n):
    a = 0
    for i in numbers:
        if a <= n:
            a += i
        else:
            break
    return a