def solution(data, col, row_begin, row_end):
    data = sorted(sorted(data, reverse = True), key = lambda x : x[col - 1])
    sum = 0
    s = []
    n = 0
    for i in range(row_begin, row_end + 1):
        for k in data[i - 1]:
            sum += k % i
        s.append(sum)
        sum = 0
    n = s[0]
    for i in s[1:]:
        n = n ^ i
    return n