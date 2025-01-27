def obstaculos(actions, track):
    track = list(track)
    for i, (action, segment) in enumerate(zip(actions, track)):
        if action == "jump" and segment == "_":
            track[i] = "x"
        elif action == "run" and segment == "|":
            track[i] = "/"
    return "_" not in track and "|" not in track, ''.join(track)

print(obstaculos(["run", "jump", "run"], "_|_"))