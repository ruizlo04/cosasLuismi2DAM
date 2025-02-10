def mayusculas(text):
    result = ''
    capitalize_next = True
    for char in text:
        if char.isspace():
            capitalize_next = True
            result += char
        elif capitalize_next:
            result += char.upper()
            capitalize_next = False
        else:
            result += char.lower()
    return result

print(mayusculas("cómo están los máquinas"))