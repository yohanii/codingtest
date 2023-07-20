def solution(n):
    answer = 0
    
    #1. 홀수 이면 0 출력
    #2. 점화식 An = An-2  + 2(An-2 + An-4 + An-6 + ...)
    
    #앞에 등장한 값들 다 더한 값
    total = 15
    
    #dic에 저장
    dic = {2 : 3, 4: 11}
    
    #홀수이면 0 출력
    if n % 2 == 1:
        return 0
    
    if n == 2:
        return 3
    elif n == 4:
        return 11
    
    index = 6
    while index <= n:
        #print(total, dic[index-2])
        value = dic[index-2] + 2*total
        dic[index] = value
        index += 2
        total += value
    
    answer = dic[n] % 1000000007
    
    
    
    return answer