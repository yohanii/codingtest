def solution(s):
    answer = []
    save = []
    
    for string in s[1:-1].split('}'):
        temp = []
        for i in string.split(','):
            if i=='':
                continue
            temp.append(int(i.replace('{', '')))
        if temp:
            save.append(temp)
    
    sortli = [0 for _ in range(len(save))]
        
    for i in save:
        sortli[len(i)-1] = i
    
    #print(sortli)
    
    for i in sortli:
        if len(i) ==1 :
            answer.append(i[0])
            continue
        for j in i:
            if j in answer:
                continue
            answer.append(j)
            
                
    
    return answer