def solution(food):
    answer = ''
    for (idx, val) in enumerate(food[1:]):
        answer += str(idx + 1) * (val // 2)
    answer += '0' + ''.join(reversed(answer))
    return answer