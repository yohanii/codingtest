def solution(maps):
    able = [(i,j) for i in range(len(maps)) for j in range(len(maps[0])) if maps[i][j]]
    
    queue = [(0,0)]
    dis = {(0,0) : 1}
    
    while queue:
        x,y = queue.pop(0)
        
        if (x,y) == (len(maps)-1, len(maps[0])-1):
            return dis[(x,y)]
        
        if (x+1, y) in able and (x+1, y) not in dis:
            queue.append((x+1, y))
            dis[(x+1, y)] = dis[(x,y)] + 1
        if (x, y+1) in able and (x, y+1) not in dis:
            queue.append((x, y+1))
            dis[(x, y+1)] = dis[(x,y)] + 1
        elif (x-1, y) in able and (x-1, y) not in dis:
            queue.append((x-1, y))
            dis[(x-1, y)] = dis[(x,y)] + 1
        elif (x, y-1) in able and (x, y-1) not in dis:
            queue.append((x, y-1))
            dis[(x, y-1)] = dis[(x,y)] + 1
        
        #print(x,y, dis)
          
    return -1




    