from sys import stdin

t = int(stdin.readline())

for _ in range(t):
    n = int(stdin.readline())
    r = [[0,0] for _ in range(n)]
    d = [[0,0] for _ in range(n)]

    for i,j in zip(range(n), map(int, stdin.readline().split())):
        r[i][0] = j
    for i,j in zip(range(n), map(int, stdin.readline().split())):
        r[i][1] = j

    #print(d)

    d[0][0] = r[0][0]
    d[0][1] = r[0][1]
    if n>1:
        d[1][0] = r[1][0] + d[0][1]
        d[1][1] = r[1][1] + d[0][0]

    for i in range(2, n):
        d[i][0] = r[i][0] + max(d[i-1][1], d[i-2][1])
        d[i][1] = r[i][1] + max(d[i-1][0], d[i-2][0])

    #print(d)
    print(max(d[n-1][0], d[n-1][1]))