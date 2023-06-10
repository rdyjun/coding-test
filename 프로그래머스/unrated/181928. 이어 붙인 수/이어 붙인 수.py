def solution(num_list):
    ans1 = ''
    ans2 = ''
    for i in num_list:
        if not i % 2:
            ans1 += str(i)
        else:
            ans2 += str(i)
        
    return int(ans1) + int(ans2)