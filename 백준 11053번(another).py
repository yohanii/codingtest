from sys import stdin

#입력
n = int(stdin.readline())
alist = [x for x in map(int, stdin.readline().split())]


value = [0]*n
for i in range(n):
    for j in range(i):
        if alist[i]>alist[j] and value[j]>value[i]:
            value[i] = value[j]
    value[i]+=1
    
print(max(value))
