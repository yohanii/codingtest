from sys import stdin

value = {1:1, 2:1, 3:1, 4:2, 5:2, 6:3}

def cal(num):
    if num<7:
        return value[num]

    for i in range(7, num+1):
        value[i] = value[i-1]+value[i-5]

    return value[num]


t = int(stdin.readline())

for _ in range(t):
    n = int(stdin.readline())
    print(cal(n))