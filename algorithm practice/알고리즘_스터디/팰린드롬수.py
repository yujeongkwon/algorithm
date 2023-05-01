def Palindrome(input_):
    if input_ == input_[::-1]:
        print('yes')
    if input_ != input_[::-1]:
        print('no')

while True:
    input_ = input()
    if input_ != '0': 
        Palindrome(input_)
        continue
    break

