oracion = "En 1984 hubo 13 casos de protesta con más de 1000 asistentes"
numeros = [int(palabra) for palabra in oracion.split() if palabra.isdigit()]
print(numeros)