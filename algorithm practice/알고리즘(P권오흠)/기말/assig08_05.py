import random
file_path = 'C:\\Users\\a0107\\Desktop\\알고리즘\\Algo_study_bj_with_python\\Alg, Sql\\algorithm\\algorithm practice\\알고리즘(P권오흠)\\기말\\input08_5.txt'

# 파일을 읽어와서 단어 리스트로 분할합니다.
with open(file_path, 'r') as f:
    text = f.read().strip()
words = text.split()

# 딕셔너리를 만듭니다.
word_dict, prefix = {}, words[0]
for i in range(1, len(words) - 1):
    key = (prefix , words[i])
    if key in word_dict:
        word_dict[key].add(words[i + 1])
    else:
        word_dict[key] = {words[i + 1]}
    prefix = words[i]

# 사용자 입력을 받습니다.
answer = list(input().split())

# 새로운 단어를 추가합니다.
i,maxLen = 0,100
while i<maxLen:
    key = (answer[i], answer[i + 1])
    if key in word_dict:
        choices = list(word_dict[key])
        answer.append(choices[random.randrange(0, len(choices))])
        i += 1
    else:
        break

print(' '.join(answer))
