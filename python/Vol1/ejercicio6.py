def procesar_arrays(lista1, lista2, buscar_comunes):
    if buscar_comunes:
        resultado = [elemento for elemento in lista1 if elemento in lista2]
    else:
        resultado = [elemento for elemento in lista1 + lista2 if (elemento in lista1) != (elemento in lista2)]
    return resultado

print(procesar_arrays([1, 2, 3], [3, 4, 5], True)) 
print(procesar_arrays([1, 2, 3], [3, 4, 5], False)) 
