from sys import stdin

#입력
n = int(stdin.readline())

save = [0,1,1,1,1,1,1,1,1,1]

#한 층 생길때
def cal(saveli):
    result = [0]*10
    for i in range(10):
        if i==0:
            result[i] = saveli[1]%1000000000
        elif i==9:
            result[i] = saveli[8]%1000000000
        else:
            result[i] = (saveli[i-1] + saveli[i+1])%1000000000

    return result

#n번 적용
if n>1:
    for _ in range(n-1):
        save = cal(save)

print(sum(save)%1000000000)