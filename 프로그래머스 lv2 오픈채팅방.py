def solution(record):
    answer = []
    newrecord = []
    rdic = {}
    
    
    for i in record:
        newrecord.append(i.split())
    #print(newrecord)
    
    for i in newrecord:
        if i[0] == 'Enter':
            rdic[i[1]] = i[2]
        elif i[0] == 'Change':
            rdic[i[1]] = i[2]
    
    for i in newrecord:
        if i[0] == 'Enter':
            answer.append(rdic[i[1]] + '님이 들어왔습니다.')
        elif i[0] == 'Leave':
            answer.append(rdic[i[1]] + '님이 나갔습니다.')
    
    return answer