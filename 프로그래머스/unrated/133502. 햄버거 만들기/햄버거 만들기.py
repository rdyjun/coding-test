def solution(ingredient):
    st = []
    answer = 0
    for i in ingredient:
        st.append(i)
        if len(st) >= 4 and st[len(st) - 4:] == [1, 2, 3, 1]:
            answer += 1
            for k in range(4):
                st.pop()
    return answer
        