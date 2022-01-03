from sys import stdin

def DFS(start, end, graph, nvisit, ntrack, dis_list):
    dis = 0
    stack = []
    track = ntrack.copy()
    visit = nvisit.copy()

    visit[start-1] = True
    #print("start, end :", start, end)
    #print("before track : ", track)
    track += [start]
    
    if start == end:
        if len(track) != 1 :
            #dis 계산
            for i in range(len(track)-1):
                for j in range(len(graph)):
                    if graph[j][0] == track[i] and graph[j][1] ==  track[i+1]:
                        dis += graph[j][2]
        dis_list += [dis]
        #print("dis list : ", dis_list)
        return dis_list
    #print("/////")
    #stack에 추가
    for n in range(len(graph)):
        if graph[n][0] == start and visit[graph[n][1]] == False:
            stack += [graph[n][1]]
    
    #print("stack : ", stack)
    #print("track : ", track)
    if not stack:
        #print("stack is empty")
        return dis_list
    for i in range(len(stack)):
        #print("DFS", stack[i], end, visit, track, dis_list)
        DFS(stack[i], end, graph, visit, track, dis_list)

    return dis_list




#입력받기
graph = []
v, e = map(int, stdin.readline().split())
k = int(stdin.readline())
for n in range(e):
    a,b,c =map(int,stdin.readline().split())
    graph += [[a,b,c]]

#출력


for i in range(v):
    visit = [False]*v
    dlist = DFS(k, i+1, graph, visit, [], [])
    if dlist:
        print(min(dlist))
    else:
        print("INF")

#print(v,e)
#print(k)
#print(graph)