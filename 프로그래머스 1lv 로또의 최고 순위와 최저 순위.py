def solution(lottos, win_nums):
    answer = []
    
    zero = 0
    count = 0
    for i in lottos:
        if i in win_nums:
            count+=1
        if i == 0:
            zero+=1
    print(count+zero, count)
    
    if count<2:
        if count+zero<2:
            answer = [6, 6]
        else:
            answer = [7-count-zero, 6]
    else:
        answer = [7-count-zero, 7-count]
    return answer