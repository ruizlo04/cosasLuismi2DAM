cadena = "que dise mi loco"
palabras_cortas = [palabra for palabra in cadena.split() if len(palabra) < 4]
print(palabras_cortas)