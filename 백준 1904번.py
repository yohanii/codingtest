from sys import stdin



n = int(stdin.readline())

ndic = {0:0, 1:1, 2:2, 3:3}


def cal(num):
    if num in ndic:
        return ndic[num]
    
    for i in range(4,num+1):
        ndic[i] = (ndic[i-1]+ndic[i-2])%15746

    return ndic[num]

print(cal(n))