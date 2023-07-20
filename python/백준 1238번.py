from sys import stdin

n, m , x = map(int, stdin.readline().split())
inf = 1000000
graph = [[]*(n+1)]


for _ in range(m):
    a,b,c = map(int, stdin.readline().split())
    graph[a].append((b,c)) 



print(n,m,x,graph)
