def ganador_piedra_papel_tijera(jugadas):
    resultados = {("R", "S"): 1, ("S", "P"): 1, ("P", "R"): 1,
                ("S", "R"): 2, ("P", "S"): 2, ("R", "P"): 2}
    puntajes = [0, 0]
    for jugada1, jugada2 in jugadas:
        if jugada1 != jugada2: 
            ganador = resultados[(jugada1, jugada2)]
            puntajes[ganador - 1] += 1
    if puntajes[0] > puntajes[1]:
        return "Jugador 1"
    elif puntajes[1] > puntajes[0]:
        return "Jugador 2"
    else:
        return "Empate"

print(ganador_piedra_papel_tijera([("R", "S"), ("S", "R"), ("P", "S")]))
