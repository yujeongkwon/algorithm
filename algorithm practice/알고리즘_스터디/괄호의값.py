#남거 뺏김 ㅎㅎ
#살짝 그 분배법칙 느낌 ( ->*2 , [ ->*3, 닫히면 //2, //3 
#또 바로 다음번에 닫히면 answer에더해주기
bracket = input()

stack = []
tmp, answer= 1,0

for i in range(len(bracket)):
    b = bracket[i]

    if b =='(':
        tmp*=2
        stack.append(b)

    elif b=='[':
        tmp*=3
        stack.append(b)

    elif b==')':
        if not stack or stack[-1]  != '(':
            answer = 0
            break
        if bracket[i-1] == '(':
            answer += tmp
        tmp //=2
        stack.pop()

    elif b==']':
        if not stack or stack[-1] != '[':
            answer = 0
            break
        if bracket[i-1] == '[':
            answer += tmp
        tmp //=3
        stack.pop()
        
if stack:
    print(0)
else:
    print(answer)


