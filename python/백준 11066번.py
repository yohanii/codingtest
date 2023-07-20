from sys import stdin


#dp[i][j] -> i에서 j까지 최소값
def cal(nlist):
    leng = len(nlist)
    dp = [[0]*leng for _ in range(leng)]
    
    for i in range(leng-1):
        dp[i][i+1] = nlist[i]+nlist[i+1]
    
    for d in range(2,leng):
        for i in range(leng-d):
            dp[i][i+d] = min([dp[i][x]+dp[x+1][i+d] for x in range(i,i+d)])
            dpsum = sum(nlist[i:i+d+1])
            dp[i][i+d] += dpsum
    print(dp[0][leng-1])    
    

#입력
t = int(stdin.readline())
for i in range(t):
    k = int(stdin.readline())
    alist = [x for x in map(int, stdin.readline().split())]
    cal(alist)

