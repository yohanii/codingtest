import sys


dic = dict()
dic[0] = [1,0]
dic[1] = [0,1]

def fib(n):
    if n in dic:
        return dic[n]
    else:
        result = [x+y for x,y in zip(fib(n-1), fib(n-2))]
        dic[n] = result
        return result

test = int(sys.stdin.readline())
for t in range(test):
    num = int(sys.stdin.readline())
    print(fib(num)[0], fib(num)[1])
