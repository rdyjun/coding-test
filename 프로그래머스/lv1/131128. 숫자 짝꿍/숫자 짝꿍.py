from collections import Counter

def solution(X, Y):
    answer = ''.join([str(i) * min(X.count(str(i)), Y.count(str(i))) for i in range(9, -1, -1)])
    return '-1' if answer == '' else '0' if answer.lstrip("0") == '' else answer.lstrip("0")