def gcd(a):
    if len(a) == 1:
        return a[0]
    else:
        x = a[0]
        for i in a[1:]:
            y = i
            while y != 0:
                x, y = y, x % y
    return x

def fat(a):
    s = set([a])
    for i in range(2, int(a ** 0.5) + 1):
        if a % i == 0:
            s.add(i)
            s.add(a // i)
    return sorted(s, reverse =  True)

def compare(arr, s):
    answer = 0
    for k in s:
        status = k
        for i in arr:
            if i % k == 0:
                status = -1
                break
        if status != -1:
            answer = k
            break
    return answer

def solution(arrayA, arrayB):
    answer = 0
    ans1 = 0
    ans2 = 0
    
    a = gcd(arrayA)
    if a != 1:
        sa = fat(a)
        ans1 = compare(arrayB, sa)
    b = gcd(arrayB)
    if b != 1:
        sb = fat(b)
        ans2 = compare(arrayA, sb)
    
    return max(ans1, ans2)