path = 'input.txt'
with open(path, 'r') as f:
    N = int(f.readline())
    team = []  # 팀 능력치
    for _ in range(N):
        line = f.readline()
        team.append([int(v) for v in line.split(' ')])
    k = f.readline()

include = []

def powerset(N): # N명의 선수들의 멱집합
    # 빈 집합을 포함한 모든 부분집합을 담을 리스트를 생성
    result = [[]]
    # 1부터 n까지의 정수에 대해 반복
    for i in range(0, N):
        # 현재까지 구한 모든 부분집합에 대해, i를 추가한 새로운 부분집합을 생성
        new_subsets = [subset + [i] for subset in result]
        # 새로운 부분집합을 결과 리스트에 추가
        result += new_subsets
    # 모든 부분집합을 담은 리스트를 반환
    return result

def get_perm(selected_members): # 선택된 멤버 중에서 2개를 뽑아 순서대로 나열
    result = []
    for i in selected_members:
        for j in range()


members = powerset(N)

selected_members = []
for i in members:
    if len(i) == k:
        selected_members.append(i)

for i in selected_members:
