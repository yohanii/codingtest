from sys import stdin

#입력
n = int(stdin.readline())
alist = [x for x in map(int, stdin.readline().split())]

root = [alist[0]]
tree = [[root[0]]]
#현재 tree의 몇번째 가지인지
max = [root[0]]

#print(tree)
for i in range(1,n):
    treelen = len(tree)
    for j in range(treelen):
        if alist[i]>max[j]:
            tree[j].append(alist[i])
            max[j] = alist[i]
        #new branch
        #tree의 각 branch마다 어떤 부분부터 큰지 파악하고 가지 늘리기
        if alist[i]<max[j] and alist[i]>root[j]:
            for index in range(len(tree[j])):
                if tree[j][index]>alist[i]:
                    tree.append(tree[j][:index])
                    tree[-1].append(alist[i])
                    max.append(alist[i])
                    root.append(tree[j][0])
    #change root when 더 작은 값 나타났을 때
    if alist[i]<min(root):
        root.append(alist[i])
        tree.append([alist[i]])
        max.append(alist[i])
    #print(root)
    #print(max)
    #print(tree)



maxlen = len(tree[0])
for i in range(len(tree)):
    if len(tree[i])>maxlen:
        maxlen = len(tree[i])
print(maxlen)
