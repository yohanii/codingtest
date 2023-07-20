def solution(id_list, report, k):
    answer = []
    
    rdic = {}
    result = {}
    
    reportset = set(report)
    for i in reportset:
        n1, n2 = i.split()
        rdic[n2] = rdic.get(n2, 0) + 1
    
    for i in reportset:
        n1, n2 = i.split()
        if rdic[n2] >= k:
            result[n1] = result.get(n1, 0) + 1
    
    for i in id_list:
        if i in result:
            answer.append(result[i])
        else:
            answer.append(0)
        
    
    return answer