def solution(s):
    answer = -1

    stack = []
    
    for i in s:
        if not stack:
            stack.append(i)
            continue
        
        if i == stack[-1]:
            stack.pop(-1)
        else:
            stack.append(i)
        
    if stack:
        return 0
    else:
        return 1
            