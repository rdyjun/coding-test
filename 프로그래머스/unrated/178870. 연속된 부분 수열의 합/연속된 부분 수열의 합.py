def solution(sequence, k):
    if sequence.count(k):
        return [sequence.index(k), sequence.index(k)]
    
    l = len(sequence)
    sm = sequence[0]
    i = 0
    answer = []
    
    for idx, val in enumerate(sequence):
        while i + 1 < l and sm + sequence[i + 1] <= k:
            i += 1
            sm += sequence[i]
            
        if sm == k:
            if answer:
                if answer[1] - answer[0] > i - idx:
                    answer = [idx, i]
            else:
                answer = [idx, i]
        
        sm -= sequence[idx]
        
        
    return answer