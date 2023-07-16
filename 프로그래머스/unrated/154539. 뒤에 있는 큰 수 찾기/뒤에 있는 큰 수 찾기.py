def solution(numbers):
    answer = [-1 for i in numbers]
    st = []
    for i in range(len(numbers)):
        while st and numbers[i] > numbers[st[-1]]:
            answer[st.pop()] = numbers[i]
        st.append(i)
    return answer