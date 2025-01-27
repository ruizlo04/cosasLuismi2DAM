def batalla(buenos, malos):
    buenos_values = [1, 2, 3, 4, 5]
    malos_values = [2, 2, 2, 3, 5]
    buenos_punt = sum(count * buenos_values[i] for i, count in enumerate(buenos))
    malos_punt = sum(count * malos_values[i] for i, count in enumerate(malos))
    return "Buenos ganan" if buenos_punt > malos_punt else "Malos ganan" if malos_punt > buenos_punt else "Tie"

print(batalla([1, 0, 0, 0, 0], [0, 1, 0, 0, 0]))