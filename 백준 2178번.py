from sys import stdin

#입력
n, m = map(int, stdin.readline().split())
mat = []
for _ in range(n):
    mat.append([x for x in map(int, stdin.readline().replace("\n", ""))])

def BFS(x,y):
    visited =[[x,y]]
    queue = [[[x,y], 1]]

    while queue:
        [a,b], deep = queue.pop(0)
        #print("a,b,deep : ", a,b,deep)
        if a==n-1 and b==m-1:
            print(deep)
            break
        if a>0:
            if mat[a-1][b] == 1 and [a-1,b] not in visited:
                queue.append([[a-1,b], deep+1])
                visited.append([a-1,b])
        if a<n-1:
            if mat[a+1][b] == 1 and [a+1,b] not in visited:
                queue.append([[a+1,b], deep+1])
                visited.append([a+1,b])
        if b>0:
            if mat[a][b-1] == 1 and [a,b-1] not in visited:
                queue.append([[a,b-1], deep+1])
                visited.append([a,b-1])
        if b<m-1:
            if mat[a][b+1] == 1 and [a,b+1] not in visited:
                queue.append([[a,b+1], deep+1])
                visited.append([a,b+1])

BFS(0,0)