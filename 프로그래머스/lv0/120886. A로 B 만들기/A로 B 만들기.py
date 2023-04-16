def solution(before, after):
    for s in after :
        if before.count(s) > 0 :
            before = before.replace(s, "", 1)
        else :
            return 0
    return 1