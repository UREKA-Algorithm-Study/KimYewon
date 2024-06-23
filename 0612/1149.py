N = int(input())
house_rgb = [list(map(int, input().split())) for _ in range(N)]

for i in range(1, N):
    house_rgb[i][0] += min(house_rgb[i-1][1], house_rgb[i-1][2])
    house_rgb[i][1] += min(house_rgb[i-1][0], house_rgb[i-1][2])
    house_rgb[i][2] += min(house_rgb[i-1][0], house_rgb[i-1][1])

print(min(house_rgb[N-1]))