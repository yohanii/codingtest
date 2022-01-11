from sys import stdin

#입력
n = int(stdin.readline())
slist = [x for x in map(int, stdin.readline().split())]

#get front
front = [0]*n
for i in range(n):
    for j in range(i):
        if slist[i]>slist[j] and front[i] < front[j]:
            front[i] = front[j]
    front[i] +=1

#print(front)

#get back
back = [0]*n
for i in range(n):
    for j in range(i):
        if slist[-i-1]>slist[-j-1] and back[-i-1] < back[-j-1]:
            back[-i-1] = back[-j-1]
    back[-i-1] +=1    
#print(back)

max=0
for i in range(n):
    result = front[i]+back[i]
    if max < result:
        max = result
print(max-1)