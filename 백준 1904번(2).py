from sys import stdin

save= {}

def fib(n):
    if n in save:
        return save[n]

    if n==1:
        save[n] = 1
    elif n==2:
        save[n] = 2
    else:
        for i in range(3, n+1):
            save[i] = (fib(i-1) + fib(i-2))%15746
                    
    return save[n]


num = int(stdin.readline())
print(fib(num))