from sys import stdin

#입력
n = int(stdin.readline())
e = int(stdin.readline())
edge = []
for _ in range(e):
    edge.append([x for x in map(int, stdin.readline().split())])

visited = []
def DFS(u):
    #print("DFS start :", u)
    visited.append(u)
    vlist = []
    for i in range(e):
        if edge[i][0]==u:
            vlist.append(edge[i][1])
        elif edge[i][1]==u:
            vlist.append(edge[i][0])
    #print(vlist)

    for i in vlist:
        if i not in visited:
            DFS(i)

DFS(1)
#print(visited)
print(len(visited)-1)