from sys import stdin

n = int(stdin.readline())

for i in range(n):
    print(' '*(n-i-1)+'*'*(i+1))