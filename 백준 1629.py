from sys import stdin

a,b,c = map(int, stdin.readline().split())

def cal(a,b,c):
    if b==1:
        return a%c
    else:
        res = cal(a,int(b/2),c)
        if b%2 ==0:
            return (res**2)%c
        else:
            return ((res**2)*a)%c

print(cal(a,b,c))