from sys import stdin

a = int(stdin.readline())
b = int(stdin.readline())
c = int(stdin.readline())
total = a*b*c
total_str = str(total)


dic = {'0':0, '1':0,'2':0,'3':0,'4':0,'5':0,'6':0,'7':0,'8':0,'9':0}
for i in range(len(total_str)):
    dic[total_str[i]] = dic[total_str[i]] + 1

for i in range(10):
    print(dic[str(i)], total_str.count(str(i)))

