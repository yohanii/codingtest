from sys import stdin

n, m  = map(int, stdin.readline().split())

def cal(a,b):
    result = 1

    for i in range(a,b+1):
        result = result * i
    return result

if m>n/2:
    a = n
    b = n-m
else:
    a = n
    b = m

print(cal(a-b+1, a)//cal(1,b))

