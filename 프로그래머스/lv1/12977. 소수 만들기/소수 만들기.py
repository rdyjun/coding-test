def solution(nums):
    answer = 0
    arr = []
    for i in range(len(nums) - 2):
        for j in range(i + 1, len(nums) - 1):
            for k in range(j + 1, len(nums)):
                n = nums[i] + nums[j] + nums[k]
                arr.append(n)
    m = set([i for i in range(max(arr) + 1)])
    for i in range(2, len(m) + 1):
        if i in m:
            m -= set([k for k in range(i * 2, max(arr) + 1, i)])
    for i in arr:
        if i in m:
            answer += 1
    
    return answer