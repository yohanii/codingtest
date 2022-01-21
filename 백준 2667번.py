from sys import stdin

#입력
n = int(stdin.readline())
mat = []
for _ in range(n):
    mat.append([x for x in map(int, stdin.readline().replace('\n',''))])

#DFS
def DFS(x, y, countnum):
    #print("DFS : ", x, y)
    count = countnum+1
    mat[x][y] = 0

    if x>0:
        if mat[x-1][y]==1:
            count = DFS(x-1, y, count)
            #print(mat)
    if x<n-1:
        if mat[x+1][y]==1:
            count = DFS(x+1, y, count)
            #print(mat)
    if y>0:
        if mat[x][y-1]==1:
            count = DFS(x, y-1, count)
            #print(mat)
    if y<n-1:
        if mat[x][y+1]==1:
            count = DFS(x, y+1, count)
            #print(mat)

    return count
            


#실행
total = 0
dfslist = []
for i in range(n):
    for j in range(n):
        if mat[i][j] == 1:
            total +=1
            dfslist.append(DFS(i,j, 0))
print(total)
dfslist.sort()
for i in dfslist:
    print(i)