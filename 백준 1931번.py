from sys import stdin


#입력
n = int(stdin.readline())
timelist = []
for i in range(n):
    timelist.append([x for x in map(int, stdin.readline().split())])

#print(timelist)
choose = []
timelist.sort(key=lambda x:(x[1], x[0]))
#print(timelist)
last = 0
for i in range(len(timelist)):
    if timelist[i][0]>=last:
        choose.append(timelist[i])
        last = timelist[i][1]
#print(choose)
print(len(choose))