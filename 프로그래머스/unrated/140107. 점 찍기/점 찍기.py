def solution(k, d):
    n = d - (d % k)
    i = 0
    answer = 0
    while i < n:
        if i * i + n * n > d * d:
            n -= k
            continue
        answer += ((n - i) // k) * 2
        i += k
            
    for j in range(0, d, k):
        if j ** 2 * 2 <= d * d:
            answer += 1
    return answer











# def solution(k, d):
#     answer = 0
#     for i in range(0, d + 1, k):
#         for j in range(0, d + 1, k):
#             if i * i + j * j > d * d:
#                 break
#             answer += 1
#     return answer