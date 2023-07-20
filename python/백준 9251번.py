from sys import stdin

word1 = stdin.readline()
word2 = stdin.readline()

len1 = len(word1)
len2 = len(word2)

matrix = matrix = [[0] * (len2) for _ in range(len1)]
#print(matrix)

for i in range(len(word1)):
    for j in range(len(word2)):
        if j==0 or i==0:
            matrix[i][j] = 0
        else:
            if word1[i-1] == word2[j-1]:
                matrix[i][j] = matrix[i-1][j-1] +1
            else:
                matrix[i][j] = max(matrix[i-1][j], matrix[i][j-1])
        #print(matrix)

print(matrix[len1-1][len2-1])
        

