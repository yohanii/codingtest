from sys import stdin

str1 = stdin.readline()
str2 = stdin.readline()
str1 = str1[:-1]
str2 = str2[:-1]

#print(str1)
#print(str2)

while True:
    leng = len(str1)
    str1 = str1.replace(str2, "")
    #print(str1)

    if leng == len(str1):
        break

if len(str1) == 0:
    print("FRULA")
else:
    print(str1)
