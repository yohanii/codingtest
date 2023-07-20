from sys import stdin

#입력
n = int(stdin.readline())
line = []
for i in range(n):
    line.append([x for x in map(int, stdin.readline().split())])

line.sort()
second =[]
for i in range(len(line)):
    second.append(line[i][1])

score = [0]*len(second)
for i in range(len(second)):
    for j in range(i):
        if score[i]<score[j] and second[i]>second[j]:
            score[i] = score[j]
    score[i]+=1

print(len(second)-max(score))