def diferencias_cadenas(frase1, frase2):
    conjunto1 = set(frase1)
    conjunto2 = set(frase2)
    
    out1 = ''.join(sorted(conjunto1 - conjunto2))  
    out2 = ''.join(sorted(conjunto2 - conjunto1))  
    
    print("Esta en la primera frase pero no en la segunda:", out1)
    print("Esta en la segunda frase pero no en la primera:", out2)

cadena1 = input("Introduce la primera cadena (frase1): ")
cadena2 = input("Introduce la segunda cadena (frase2): ")

diferencias_cadenas(cadena1, cadena2)
