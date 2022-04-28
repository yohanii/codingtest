import sys

save = dict()
save[(0,0,0)] = 1


def cal(a,b,c):
    if a<=0 or b<=0 or c<=0:
        return 1
    elif (a,b,c) in save:
        return save[(a,b,c)]
    elif a>20 or b>20 or c>20:
        return cal(20, 20, 20)
    elif a<b and b<c:
        x = cal(a,b,c-1)
        y = cal(a,b-1,c-1)
        z = cal(a,b-1,c)
        save[(a,b,c-1)]=x
        save[(a,b-1,c-1)]=y
        save[(a,b-1,c)]=z
        return  x+ y - z
    else:
        x = cal(a-1,b,c)
        y = cal(a-1,b-1,c)
        z = cal(a-1,b,c-1)
        w = cal(a-1,b-1,c-1)
        save[(a-1,b,c)]=x
        save[(a-1,b-1,c)]=y
        save[(a-1,b,c-1)]=z
        save[(a-1,b-1,c-1)]=w
        return x + y+ z-w

while 1:
    a,b,c = map(int, sys.stdin.readline().split())
    if a==-1 and b==-1 and c==-1:
        break
    print("w(%d, %d, %d) = %d"%(a,b,c,cal(a,b,c)))