#한줄에 10자씩 끊어서
word = input()

while word:
    print(word[:10])
    word = word[10:]