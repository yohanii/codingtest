def solution(numbers, hand):
    answer = ''
    
    distance = {('*',2):4, ('*',5):3, ('*',8):2, ('*',0):1, 
               (1,2):1, (1,5):2, (1,8):3, (1,0):4,
               (4,2):2, (4,5):1, (4,8):2, (4,0):3,
               (7,2):3, (7,5):2, (7,8):1, (7,0):2,
               (3,2):1, (3,5):2, (3,8):3, (3,0):4,
               (6,2):2, (6,5):1, (6,8):2, (6,0):3,
               (9,2):3, (9,5):2, (9,8):1, (9,0):2,
                ('#',2):4, ('#',5):3, ('#',8):2, ('#',0):1,
                (2,2):0, (2,5):1, (2,8):2, (2,0):3,
                (5,2):1, (5,5):0, (5,8):1, (5,0):2,
                (8,2):2, (8,5):1, (8,8):0, (8,0):1,
                (0,2):3, (0,5):2, (0,8):1, (0,0):0
               }
    
    left = '*'
    right = '#'
    for i in numbers:
        if i in [1,4,7]:
            answer += 'L'
            left = i
        elif i in [3,6,9]:
            answer += 'R'
            right = i
        else:
            if distance[(left, i)] < distance[(right, i)]:
                answer += 'L'
                left = i
            elif distance[(left, i)] > distance[(right, i)]:
                answer += 'R'
                right = i
            else:
                if hand == 'left':
                    answer += 'L'
                    left = i
                else:
                    answer += 'R'
                    right = i
        

    return answer