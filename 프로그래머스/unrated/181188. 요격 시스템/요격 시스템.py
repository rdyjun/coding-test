def solution(targets):
    c = 1
    targets = sorted(targets)
    ms = targets[0]
    
    for i in targets:
        if ms[0] <= i[0] and ms[1] > i[0]:
            ms[0] = i[0]
            ms[1] = min(ms[1], i[1])
        else:
            c += 1
            ms = i
    return c