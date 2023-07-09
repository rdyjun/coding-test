def solution(num_list):
    for i in range(5):
        del num_list[num_list.index(min(num_list))]
    return sorted(num_list)