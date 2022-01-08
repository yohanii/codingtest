from sys import stdin

#입력 1<=n<=500
n = int(stdin.readline())
graph = [[]]*n
for i in range(n):
    graph[i] = [x for x in map(int, stdin.readline().split())]

#풀이
for i in range(1,n):
    for j in range(i+1):
        if j==0:
            graph[i][j] = graph[i][j] + graph[i-1][j]
        elif j==i:
            graph[i][j] = graph[i][j] + graph[i-1][j-1]
        else:
            graph[i][j] = graph[i][j] + max(graph[i-1][j-1], graph[i-1][j])

print(max(graph[n-1]))


