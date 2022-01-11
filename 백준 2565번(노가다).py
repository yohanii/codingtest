from sys import stdin

#입력
n = int(stdin.readline())
line = []
for i in range(n):
    line.append([x for x in map(int, stdin.readline().split())])

#print(line)


#교차하는 쌍 리스트로 나타내기
cross = []
for i in range(n):
    for j in range(i+1, n):
        if (line[i][0]>line[j][0] and line[i][1]<line[j][1]) or (line[i][0]<line[j][0] and line[i][1]>line[j][1]):
            cross.append([line[i][0],line[j][0]])
#print(cross)

#지워야할 최소 개수 구하기
count = 0
while cross:
    #cross에 가장 많이 있는 수 구하기
    cdic = {}
    for i in range(len(cross)):
        for j in range(2):
            value = cross[i][j]
            if value in cdic:
                cdic[value] +=1
            else:
                cdic[value] = 1
    maxkey = max(cdic, key = cdic.get)
    crosslen = len(cross)
    for i in range(crosslen):
        #print(crosslen-i-1)
        if maxkey in cross[crosslen-i-1]:
            del cross[crosslen-i-1]
        #print(cross)
    count +=1
    #print(cross, count)
print(count)

#답 틀림