def solution(arr1, arr2):
    for i in range(len(arr1)):
        for k in range(len(arr1[0])):
            arr1[i][k] += arr2[i][k]
    
    return arr1