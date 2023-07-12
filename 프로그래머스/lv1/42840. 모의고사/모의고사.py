def solution(answers):
    l = len(answers)
    t = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    t2 = [1, 3, 4, 5]
    arr1 = [i % 5 + 1 for i in range(l)]
    arr2 = [2 if i % 2 == 0 else t2[i // 2 % 4] for i in range(l)]
    arr3 = [t[i % 10] for i in range(l)]
    
    ans = [0, 0, 0]
    for idx, val in enumerate(answers):
        if arr1[idx] == val:
            ans[0] += 1
        if arr2[idx] == val:
            ans[1] += 1
        if arr3[idx] == val:
            ans[2] += 1

    n = max(ans)
    aarr = set()
    for i in range(3):
        if ans[i] == n:
            aarr.add(i + 1)
    return list(aarr)