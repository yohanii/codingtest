from sys import stdin

def BFS(x,y, map):
    #print("BFS start", x, y)
    matrix = map
    queli = [[x,y]]
    visited =[]

    while queli:
        a, b = queli.pop(0)
        #print(matrix, a, b)
        matrix.remove([a,b])
        visited.append([a,b])
        if [a+1, b] in matrix and [a+1, b] not in visited:
            queli.append([a+1, b])
            visited.append([a+1,b])
        if [a-1, b] in matrix and [a-1, b] not in visited:
            queli.append([a-1, b])
            visited.append([a-1,b])
        if [a, b+1] in matrix and [a, b+1] not in visited:
            queli.append([a, b+1])
            visited.append([a,b+1])
        if [a, b-1] in matrix and [a, b-1] not in visited:
            queli.append([a, b-1])
            visited.append([a,b-1])
        
#입력
t = int(stdin.readline())
for _ in range(t):
    m, n, k = map(int, stdin.readline().split())
    mat = []
    for _ in range(k):
        mat.append([x for x in map(int, stdin.readline().split())])
    count = 0
    while mat:
        x, y = mat[0]
        #print("x, y", x, y)
        BFS(x, y, mat)
        #print(mat)
        count+=1
    print(count)
    


