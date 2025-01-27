def delimitadores(expresion):
    almacen = []
    pairs = {')': '(', '}': '{', ']': '['}

    for char in expresion:
        if char in pairs.values(): 
            almacen.append(char)
        elif char in pairs.keys():
            if not almacen or almacen.pop() != pairs[char]:
                return False

    return len(almacen) == 0 

print(delimitadores("{ [ a * ( c + d ) ] - 5 }"))  
print(delimitadores("{ a * ( c + d ) ] - 5 }")) 
