def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def solution(weights):
    answer = 0
    sortedarr = sorted(weights)
    n = sortedarr[0]
    s = 0
    e = 0
    arr = dict()
    st = {n}

    for i, v in enumerate(sortedarr):
        if n == v:
            e = i
            if len(sortedarr) - 1 == i:
                answer += ((e - s + 1) * (e - s) / 2)
                arr[v] = e - s + 1
                st.add(v)
        else:
            if s != e:
                answer += ((e - s + 1) * (e - s) / 2)
            arr[n] = e - s + 1
            arr[v] = 1
            st.add(n)
            st.add(v)
            n = v
            s = i
            e = i
    
    st = list(st)
    for i, v in enumerate(st[:-1]):
        for i2, v2 in enumerate(st[i + 1:]):
            rs = gcd(v2, v)
            a =  v / rs
            b =  v2 / rs
            if (min(a, b) == 2 and max(a, b)) == 3 or min(a, b) / max(a, b) in (0.5, 0.75):
                answer += arr[v] * arr[v2]
    
    return int(answer)