def solution(arr, k):
    answer = []
    for i in arr :
        answer.append(i * k if k % 2 else i + k)
    return answer