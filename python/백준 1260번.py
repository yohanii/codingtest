from sys import stdin

n, m, start = map(int, stdin.readline().split())

graph = []

for _ in range(m):
    x,y = map(int, stdin.readline().split())
    if x<y:
        graph.append([x,y])
    else:
        graph.append([y,x])
graph.sort()


visit = []
def DFS(u):
    print(u, end = ' ')
    visit.append(u)

    for ele in graph:
        if ele[0] == u and ele[1] not in visit:
            DFS(ele[1])
        if ele[1] == u and ele[0] not in visit:
            DFS(ele[0])

     
DFS(start)

print()

def BFS(u):
    visit.append(u)
    queue = [u]

    while queue:
        elem = queue.pop(0)
        print(elem, end = ' ')
        for ele in graph:
            if ele[0] == elem and ele[1] not in visit and ele[1] not in queue:
                visit.append(ele[1])
                queue.append(ele[1])
            if ele[1] == elem and ele[0] not in visit and ele[0] not in queue:
                visit.append(ele[0])
                queue.append(ele[0])
                
            
visit = []
BFS(start)

        






