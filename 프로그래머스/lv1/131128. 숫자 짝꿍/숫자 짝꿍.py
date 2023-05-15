from collections import Counter

def solution(X, Y):
    if len([i for i in range(0, 10) if min(X.count(str(i)), Y.count(str(i))) != 0]) <= 0:
        return "-1"
    st = ''.join([str(i) * min(X.count(str(i)), Y.count(str(i))) for i in range(9, -1, -1) if min(X.count(str(i)), Y.count(str(i)))]).lstrip('0')
    return st if st != "" else "0"