def solution(r1, r2):
    return a(r2) - a(r1) + b(r1)

def a(r):
    result = 0
    max = r - 1
    for i in range(1, r):
        x = i
        y = i
        if i ** 2 + y ** 2 <= r ** 2:
            result += 1
            
        for k in range(max, x, -1):
            if k ** 2 + y ** 2 <= r ** 2:
                result += (k - x) * 2
                break
            else:
                max -= 1
        
    return (result + r) * 4 + 1

def b(r):
    result = 0
    max = r
    for i in range(1, r):
        x = i
        y = i
        for k in range(max, x, -1):
            if k ** 2 + y ** 2 <= r ** 2:
                if k ** 2 + y ** 2 == r ** 2:
                    result += 1
                break
            else:
                max -= 1
        
    return result * 8 + 4