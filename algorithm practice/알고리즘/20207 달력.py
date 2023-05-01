N = int(input())
calendar = [0] * 366
for i in range(N):
    s, e = map(int,input().split())
    for j in range(s,e+1):
        calendar[j] += 1

answer, width,height,now =0, 0, 0, 0
for i in range(366):
    if calendar[i]:
        width += 1
        height = max(height,calendar[i])
    else:
        answer += width* height
        width,height = 0,0

answer += width*height
print(answer)

# N = int(input())
# schedule = []
# for i in range(N):
#     schedule.append(list(map(int,input().split())))

# schedule.sort()
# print(schedule)
# height, width, now, start, end, new_strat = [1], [schedule[0][:]], 0,0,1,0

# for i in range(1,len(schedule)):
#     if schedule[i][start] > width[now][end]: 
#         width.append(schedule[i][:])
#         height.append(1)
#         now += 1
#         new_strat = i
#     else:
#         if schedule[i][start] < width[now][start]:
#             width[now][start] = schedule[i][start]
#         if schedule[i][end] > width[now][end]:
#             width[now][end] = schedule[i][end] 
#         #같은 층에 끼어들 수 있는가?
        
#         cnt= 0
#         for j in range(new_strat,i):
#             print(schedule[i], schedule[j])
#             if schedule[i][end] < schedule[j][start]:
#                 cnt += 1
#                 print(cnt)
#             if schedule[i][start] > schedule[j][end]:
#                 cnt += 1
#                 print(cnt)
#         if cnt >= 1:    height[now] += 1

#     print(height)
#     print(width)
#     print()
# # import heapq

# # N = int(input())
# # schedule = []
# # for i in range(N):
# #     schedule.append(list(map(int,input().split())))

# # schedule.sort()
# # print(schedule)
# # height = [1]
# # width = [[schedule[0][1],schedule[0][0]]]

# # for i in range(1,N):
    
# #     for w in range(len(width)):
# #         if width[w][0] >= schedule[i][0]:
# #             height[w] += 1
# #             if width[w][0] < schedule[i][1]:
# #                 width[w][0] = schedule[i][1]
# #             break
# #     else:
# #         heapq.heappush(width, [schedule[i][1],schedule[i][0]])
# #         height.append(1)
# #     print(height)
# #     print(width)
# # print(height)
# # print(width)
# # # rectangle = [[width[0],height[0]]]
# # # for i in range(1,len(width)):
# # #     if width[i][