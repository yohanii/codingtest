from sys import stdin

#입력
n = int(stdin.readline())

score = [0,0]

for i in range(2,n+1):
    score.append(score[i-1]+1)
    if i%2==0 and score[i]>score[i//2]+1:
        score[i] = score[i//2]+1
    if i%3==0 and score[i]>score[i//3]+1:
        score[i] = score[i//3]+1
print(score[n])
