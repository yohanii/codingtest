from sys import stdin

wdic = {}

def w(a,b,c):
    if a<=0 or b<=0 or c<=0:
        return 1
    if a>20 or b>20 or c>20:
        return w(20, 20, 20)
    if (a,b,c) in wdic:
        return wdic[(a,b,c)]
    if a<b and b<c:
        result = w(a,b,c-1)+ w(a,b-1, c-1)-w(a,b-1,c)
        wdic[(a,b,c)]=result
        return result
    result = w(a-1, b,c)+w(a-1, b-1, c)+w(a-1, b, c-1)-w(a-1, b-1, c-1)
    wdic[(a,b,c)]=result
    return result
    

while 1:
    a,b,c = map(int, stdin.readline().split())
    if (a,b,c)==(-1,-1,-1):
        break
    else:
        print("w(%d, %d, %d) = %d"%(a, b, c, w(a,b,c)))