def calcular_batalla(ejercito_bueno, ejercito_malo):
    valores_buenos = [1, 2, 3, 4, 5]
    valores_malos = [2, 2, 2, 3, 5]
    puntos_buenos = sum(cantidad * valores_buenos[indice] for indice, cantidad in enumerate(ejercito_bueno))
    puntos_malos = sum(cantidad * valores_malos[indice] for indice, cantidad in enumerate(ejercito_malo))
    
    if puntos_buenos > puntos_malos:
        return "El bien prevalece"
    elif puntos_malos > puntos_buenos:
        return "El mal triunfa"
    else:
        return "Empate total"

print(calcular_batalla([1, 0, 0, 0, 0], [0, 1, 0, 0, 0]))
