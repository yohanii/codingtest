def solution(n):
    answer = []
    
    if n==1:
        return [1]
    li = [[0]*i for i in range(n+1)]
    
    
    bottom = 2
    top = n
    
    count = 1
    index = 1
    iter = 0
    
    while bottom <= top:
        while index <= top:
            if li[index][iter] == 0:
                li[index][iter] = count
                count += 1
            index += 1
            
        #print(li)

        index -= 1
        for i in range(top - 1):
            if li[index][i+1] == 0:
                li[index][i+1] = count
                count += 1
        top -= 1

        #print(li)

        index -= 1
        while index >= bottom:
            if li[index][-1-iter] == 0:
                li[index][-1-iter] = count
                count += 1
            index -= 1
            
        #print(li)

        index += 2
        bottom +=1

        iter+=1
        
    #answer = sum(li, [])로 대체 가능.
    for i in li:
        for j in i:
            answer.append(j)
    
    return answer