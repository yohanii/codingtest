from sys import stdin

N, K = map(int, stdin.readline().split())
wvlist = []
for i in range(N):
    wvlist.append([x for x in map(int, stdin.readline().split())])

n = N
k = K
dp = [[0]*(k+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,k+1):
        if j-wvlist[i-1][0]>=0:
            dp[i][j] = max(dp[i-1][j], wvlist[i-1][1] + dp[i-1][j-wvlist[i-1][0]])
        else:
            dp[i][j] = dp[i-1][j]
        #print(i, j)
        #print(dp)
print(dp[n][k])