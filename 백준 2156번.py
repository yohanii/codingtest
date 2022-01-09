from sys import stdin

#입력 1<=n<=10000, 0<=amount[i]<=1000
n = int(stdin.readline())

amount = [0] * n
for i in range(n):
    amount[i] = int(stdin.readline())

sumlist = [0]*n

#sumlist 구하기
for i in range(n):
    if i==0:
        sumlist[i] = amount[0]
    elif i ==1:
        sumlist[i] = amount[0]+amount[1]
    elif i==2:
        minval = min(amount[0], amount[1], amount[2])
        sumlist[i] = amount[0]+amount[1]+amount[2]-minval
    else:
        sumlist[i] = max(sumlist[i-1], sumlist[i-2]+amount[i], sumlist[i-3]+amount[i-1]+amount[i])

print(sumlist[n-1])