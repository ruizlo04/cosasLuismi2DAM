divisibles = [num for num in range(1, 1001) if any(num % d == 0 for d in range(2, 10))]
print(divisibles)