from cmath import inf
from sys import stdin

#입력
n = int(stdin.readline())
road = [x for x in map(int, stdin.readline().split())]
cost = [x for x in map(int, stdin.readline().split())]


#minli추출
minli = []
minval = float("inf")
for i in range(len(cost)):
    if cost[i]<minval:
        minval = cost[i]
    minli.append(minval)

#print(minli)

#total계산
total = 0
for i in range(len(minli)-1):
    total += minli[i]*road[i]
    #print(minli[i], road[i], total)
print(total)