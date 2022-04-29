from sys import stdin

n = int(stdin.readline())
scoreli = [int(x) for x in stdin.readline().split()]

total = 0
for i in scoreli:
    total += i
maxele = max(scoreli)

ntotal = float(total)*100/maxele
print(ntotal/n)