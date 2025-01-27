def piedra_papel_tijera(matches):
    outcomes = {("R", "S"): 1, ("S", "P"): 1, ("P", "R"): 1,
                ("S", "R"): 2, ("P", "S"): 2, ("R", "P"): 2}
    score = [0, 0]
    for p1, p2 in matches:
        if p1 != p2:
            score[outcomes[(p1, p2)] - 1] += 1
    return "Player 1" if score[0] > score[1] else "Player 2" if score[1] > score[0] else "Tie"

print(piedra_papel_tijera([("R", "S"), ("S", "R"), ("P", "S")]))