cadena = "que dise mi loco"

vocales = "aeiouáéíóúAEIOUÁÉÍÓÚ"

consonantes = [letra for letra in cadena if letra.isalpha() and letra not in vocales]

print(consonantes)
