textoAMorse = {
    'A': '.-', 'R': '.-.', 'L': '.-..', 'C': '-.-.', 'O': '---', 'N': '-.',
    'E': '.', 'S': '...', 'T': '-', 'U': '..-', 'P': '.--.', 'M': '--', 'I': '..',
    'D': '-..', 'G': '--.', 'B': '-...', 'V': '...-', 'H': '....', 'F': '..-.',
    'Y': '-.--', 'W': '.--', 'K': '-.-', 'J': '.---', 'Z': '--..', 'Q': '--.-',
    'X': '-..-'
}

morseATexto = {value: key for key, value in textoAMorse.items()}

texto = input("Introduce un texto: ").upper()
for letra in texto:
    print(textoAMorse[letra])

morse = input("Introduce un código morse: ").split()
for codigo in morse:
    print(morseATexto[codigo], end="")
