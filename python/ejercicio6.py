def array_diferentes(arr1, arr2, find_common):
    if find_common:
        return [item for item in arr1 if item in arr2]
    else:
        return [item for item in arr1 + arr2 if (item in arr1) ^ (item in arr2)]

print(array_diferentes([1, 2, 3], [3, 4, 5], True))
print(array_diferentes([1, 2, 3], [3, 4, 5], False))