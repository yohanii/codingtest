from sys import stdin

#입력
n=int(stdin.readline())
x = []
for _ in range(n):
    x.append([t for t in map(int, stdin.readline().split())])


def cal(num, xlist):
    dp = [[0]*(num) for _ in range(num)]

    for i in range(n-1):
        dp[i][i+1] = xlist[i][0]*xlist[i][1]*xlist[i+1][1]

    for deep in range(2,n):
        for i in range(n-deep):
            slist = []
            for k in range(deep):
                slist.append(dp[i][i+k] + dp[i+k+1][i+deep] + xlist[i][0]*xlist[i+k][1]*xlist[i+deep][1])
            #print(slist)
            dp[i][i+deep] = min(slist)
            #print(i, i+deep, dp[i][i+deep])
    
    return dp[0][n-1]

print(cal(n, x))
