from sys import stdin

n, m = map(int, stdin.readline().split())

truth = [int(x) for x in stdin.readline().split()]
del truth[0]

party = []
for _ in range(m):
    plist = [int(x) for x in stdin.readline().split()]
    del plist[0]
    party.append(plist)

newmem = truth.copy()

while newmem:
    ele = newmem.pop(0)
    for i in party:
        if ele in i:
            for j in i:
                if j != ele and j not in truth:
                    #print(ele, i, j, truth, newmem)
                    newmem.append(j)
                    truth.append(j)

resultli = party.copy()
for i in party:
    for j in truth:
        if j in i:
            if i not in resultli:
                continue
            resultli.remove(i)
#print(truth)
print(len(resultli))
                