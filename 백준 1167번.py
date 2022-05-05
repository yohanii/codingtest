from sys import stdin

n = int(stdin.readline())
graph = []

for _ in range(n):
    t = []
    tmp = [x for x in map(int, stdin.readline().split())]
    i=1
    while i < len(tmp)-1:
        t.append([tmp[i], tmp[i+1]])
        i += 2
    graph.append(t)

#print(n, graph)


def dfs(u, total):
    #print("visit", u, total)
    visit.append(u)
    if total > max[0]:
        max[0] = total
        max[1] = u

    for i in range(len(graph[u-1])):
        if graph[u-1][i][0] not in visit:
            dfs(graph[u-1][i][0], total + graph[u-1][i][1])
    

#1~n에 대해서 dfs모두 돌려서 최대길이 찾기


max = [0, 0]
visit = []
dfs(1, 0)
dfs(max[1], 0)
print(max[0])

