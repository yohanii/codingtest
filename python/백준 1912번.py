from re import L
from sys import stdin

n= int(stdin.readline())
numli = [x for x in map(int, stdin.readline().split())]

sum = []
for i in range(len(numli)):
    if i == 0:
        sum.append(numli[0])
    #print(i)
    if i<len(numli)-1:
        sum.append(max(numli[i+1], sum[i]+numli[i+1]))
print(max(sum))