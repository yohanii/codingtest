from sys import stdin

#입력 string 마지막에 \n포함되어있음
string = stdin.readline()

total = 0
sign = 1
saveindex = 0
for i in range(len(string)):
    if string[i]=="\n":
        total+=int(string[saveindex:i])*sign
    if string[i]=="+":
        total+=int(string[saveindex:i])*sign
        saveindex = i+1
        #print(total)
    if string[i]=="-":
        total+=int(string[saveindex:i])*sign
        saveindex = i+1
        sign = -1
        #print(total)

print(total)