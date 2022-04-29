from sys import stdin

while 1:
    xlist = [int(x) for x in stdin.readline().split()]
    if len(xlist) == 2:
        x = xlist[0]
        y = xlist[1]
        if x>0 and x<10 and y>0 and y<10:
            print(x+y)
        else:
            break
    else:
        break