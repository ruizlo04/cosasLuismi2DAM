def evaluar_carrera(movimientos, pista):
    pista_modificada = list(pista) 
    for indice, (movimiento, tramo) in enumerate(zip(movimientos, pista_modificada)):
        if movimiento == "jump" and tramo == "_":  
            pista_modificada[indice] = "x" 
        elif movimiento == "run" and tramo == "|": 
            pista_modificada[indice] = "/" 
    carrera_exitosa = "_" not in pista_modificada and "|" not in pista_modificada
    return carrera_exitosa, ''.join(pista_modificada)

resultado, pista_final = evaluar_carrera(["run", "jump", "run"], "_|_")
print("Carrera exitosa:", resultado)
print("Pista final:", pista_final)
