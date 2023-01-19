def solution(numbers):
    answer = []
    for i in range(0, len(numbers) - 1):
        for k in range(1 + i, len(numbers)):
            answer.append(numbers[i] + numbers[k])
    a = list(set(answer))
    a.sort()
    return a