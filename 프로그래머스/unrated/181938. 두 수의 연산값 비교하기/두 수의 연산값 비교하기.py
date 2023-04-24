def solution(a, b):
    a = str(a)
    b = str(b)
    return int(a + b) if int(a + b) > 2 * int(a) * int(b) else 2 * int(a) * int(b)