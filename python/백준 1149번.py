from sys import stdin

#입력
n = int(stdin.readline())

rgblist = [[0]*3]*(n+1)
for i in range(1,n+1):
    a,b,c = map(int, stdin.readline().split())
    rgblist[i] = [a,b,c]



def cal(num):
    #value = [[0]*3]*(num+1)
    value = [[]]*(num+1)
    value[1] = rgblist[1]
    for i in range(2, n+1):
        value[i] = [0,0,0]
        value[i][0] = rgblist[i][0] + min(value[i-1][1], value[i-1][2])
        value[i][1] = rgblist[i][1] + min(value[i-1][0], value[i-1][2])
        value[i][2] = rgblist[i][2] + min(value[i-1][0], value[i-1][1])

    return min(value[num][0], value[num][1], value[num][2])


print(cal(n))


