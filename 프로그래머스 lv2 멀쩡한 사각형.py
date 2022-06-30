def solution(w,h):
    answer = 1
    
    big = max(w,h)
    small = min(w,h)
    
    #최소공배수 구하기
    while big%small != 0:
        temp = small
        small = big%small
        big = temp
        
    g = small
    
    
    #값 구하기
    answer = w*h - g*(w/g + h/g - 1)
    
    
    return answer