def solution(x):
    answer = True
    a = 0;
    for i in range(len(str(x))):
        a += int(str(x)[i])
    if x % a == 0:
        return True
    else:
        return False