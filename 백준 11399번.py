from sys import stdin

#입력
n = int(stdin.readline())
timeli = [x for x in map(int, stdin.readline().split())]

timeli.sort()

total = 0
for i in range(len(timeli)):
    total += sum(timeli[:i+1])
print(total)