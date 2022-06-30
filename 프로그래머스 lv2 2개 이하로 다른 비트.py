def solution(numbers):
    answer = []
    
    for x in numbers:
        answer.append(f(x))
    
    return answer

def f(x):
    b = bin(x)
    #print(b)
    
    if b[-1]=='0':
        return x+1
    else:
        index = 0
        #마지막 1찾기
        i = len(b) -2
        while True:
            if b[i] == 'b' or b[i] == '0':
                index = i+1
                break
            i -= 1
        return x + 2**(len(b)-1-index)
            