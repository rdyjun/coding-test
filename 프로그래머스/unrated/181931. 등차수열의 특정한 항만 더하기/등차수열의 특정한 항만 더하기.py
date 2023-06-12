def solution(a, d, included):
    return sum(idx * d + a for (idx,val) in enumerate(included) if val)