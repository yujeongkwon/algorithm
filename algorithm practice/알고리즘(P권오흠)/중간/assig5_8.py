import csv
import datetime

f = open('weblog.csv', 'r', encoding='utf-8')
read = list(csv.reader(f))
web_log = []
for i in range(1,len(read)):
    web_log.append(read[i])
f.close()

def sort_time():
    web_log.sort(key = lambda x : datetime.datetime.strptime(x[1],'[%d/%b/%Y:%H:%M:%S'))

def sort_ip():
    web_log.sort(key = lambda x : ''.join(x[0].split('.')))


def print_():
    for log in web_log:
        print(log)


input_= input()
while(input_ != 'exit'):
    if input_ == 'sort -ip':
        sort_ip()
    elif input_ == 'sort -t':
        sort_time()
    elif input_ == 'print':
        print_()
    else:
        print("잘못된 입력입니다. (sort -ip, sort -t, print) 중에 하나를 입력하세요.  ")
        print("종료를 원하신다면 'exit'을 입력하세요 : ")
    
    input_ = input()


