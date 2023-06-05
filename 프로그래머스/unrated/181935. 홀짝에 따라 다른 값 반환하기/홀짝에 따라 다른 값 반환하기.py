def solution(n):
    return sum(i + 1 if (i + 1) % 2 == 1 else 0 for i in range(n)) if n % 2 == 1 else sum((i + 1) ** 2 for i in range(n) if (i + 1) % 2 == 0)