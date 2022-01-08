from sys import stdin

#입력 : 계단개수<=300, 점수<=10000
n = int(stdin.readline())
score = [[]]*n
for i in range(n):
    score[i] = int(stdin.readline())

#scoresum 각 계단까지의 최댓값으로 바꾸기
scoresum = [[]]*n
def change(num):
    for i in range(0,num):
        if i==0:
            scoresum[i] = score[i]
        elif i ==1:
            scoresum[i] = score[i]+scoresum[i-1]
        elif i==2:
            scoresum[i] = score[i]+max(score[i-1], score[i-2])
        else:
            scoresum[i] = score[i] + max(scoresum[i-2], score[i-1]+scoresum[i-3])

change(n)
print(scoresum[n-1])