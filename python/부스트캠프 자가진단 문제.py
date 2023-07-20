arr = [3, 2, 4, 5]

dic = {}
for i in arr:
    dic[i] = dic.get(i, 0) + 1

result = [v for k,v in dic.items() if v>1]

if result:
    print(result)
else:
    print([-1])