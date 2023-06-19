import heapq
from sys import stdin
import math


#입력받기

v, e = map(int, stdin.readline().split())
k = int(stdin.readline())

dis = [math.inf]*(v+1)
graph = [[] for _ in range(v + 1)]

for n in range(e):
    a,b,c =map(int,stdin.readline().split())
    graph[a].append((c, b))


#graph = [[5, 1, 1], [1, 2, 2], [1, 3, 3], [2, 3, 4], [2, 4, 5], [3, 4, 6]]
def dijkstra(start):
    dis[start] = 0
    #start에 대한 heap 가져오기
    heap = []
    #for [a,b,c] in graph:
    #    if a == start:
    #        heapq.heappush(heap, (c,b))
    #        dis[b] = c
    heapq.heappush(heap, (0,start))
    #print(heap)
    #반복
    while heap:
        #가중치 제일 낮은 거 가져오기
        elem = heapq.heappop(heap)
        ele = elem[1]

        if dis[ele]<elem[0]:
            continue
        
        #업데이트 하기
        for w,x in graph[ele]:
            if dis[x]>elem[0]+w:
                dis[x] = elem[0]+w
                heapq.heappush(heap, (dis[x], x))
        #print(heap)



#print(getw(2))
dijkstra(k)

for i in range(v):
    result = dis[i+1]
    if result == math.inf:
        print("INF")
    else:
        print(result)