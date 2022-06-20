def solution(expression):
    answer = 0
    
    nums = []
    ops = []
    
    start=0
        
    for i in range(len(expression)):
        if i== len(expression)-1:
            nums.append(expression[start:])
        
        if expression[i] == '+' or expression[i] == '-' or expression[i] == '*':
            nums.append(expression[start:i])
            ops.append(expression[i])
            start = i+1
    
    case = [['*', '+', '-'], ['*', '-', '+'], ['+', '*', '-'], ['+', '-', '*'], ['-', '+', '*'], ['-', '*', '+']]
    result = []
    
    for prior in case:
        newnums = nums.copy()
        newops = ops.copy()
        for pri in prior:
            for op in ops:
                if pri == op:
                    index = newops.index(op)
                    del newops[newops.index(op)]
                    if pri== '*':
                        value = int(newnums[index]) * int(newnums[index+1])
                    elif pri == '+':
                        value = int(newnums[index]) + int(newnums[index+1])
                    else:
                        value = int(newnums[index]) - int(newnums[index+1])
                    del newnums[index+1]
                    del newnums[index]
                    newnums.insert(index, value)
        if newnums[0]<0:
            result.append(-newnums[0])
        else:
            result.append(newnums[0])
        
    answer = max(result)

    return answer