import csv

def leer_alumnos(ruta_archivo):
    alumnos = []
    with open(ruta_archivo, newline='', encoding='utf-8') as f:
        lector = csv.reader(f)
        for fila in lector:
            nombre_completo = fila[0].split(', ')
            if len(nombre_completo) < 2:
                continue
            alumno = {
                "nombre": nombre_completo[1],
                "apellidos": nombre_completo[0],
                "curso": fila[2],
                "notas": {
                    "FH": int(fila[3]), "LM": int(fila[4]), "ISO": int(fila[5]),
                    "FOL": int(fila[6]), "PAR": int(fila[7]), "SGBD": int(fila[8])
                }
            }
            alumnos.append(alumno)
    return alumnos

def calcular_nota_media(notas):
    return sum(notas.values()) / len(notas)

def mostrar_notas_medias(alumnos):
    print("Listado de alumnos con nota media:")
    for alumno in alumnos:
        media = calcular_nota_media(alumno["notas"])
        print(f"{alumno['nombre']} {alumno['apellidos']} ({alumno['curso']}): {media:.2f}")

def mostrar_notas_asignatura(alumnos, curso, asignatura):
    print(f"Notas de {asignatura} en el curso {curso}:")
    for alumno in alumnos:
        if alumno["curso"] == curso:
            print(f"{alumno['nombre']} {alumno['apellidos']}: {alumno['notas'].get(asignatura, 'N/A')}")

def calcular_porcentaje_aprobados(alumnos, curso):
    asignaturas = ["FH", "LM", "ISO", "FOL", "PAR", "SGBD"]
    aprobados = {asignatura: 0 for asignatura in asignaturas}
    total_alumnos = sum(1 for alumno in alumnos if alumno["curso"] == curso)
    if total_alumnos == 0:
        print("No hay alumnos en este curso.")
        return
    
    for alumno in alumnos:
        if alumno["curso"] == curso:
            for asignatura in asignaturas:
                if alumno["notas"].get(asignatura, 0) >= 5:
                    aprobados[asignatura] += 1
    
    print(f"Porcentaje de aprobados en el curso {curso}:")
    for asignatura, cantidad in aprobados.items():
        porcentaje = (cantidad / total_alumnos) * 100
        print(f"{asignatura}: {porcentaje:.2f}%")

def guardar_notas_curso(alumnos, curso):
    nombre_archivo = f"{curso}.txt"
    with open(nombre_archivo, "w", encoding="utf-8") as f:
        for alumno in alumnos:
            if alumno["curso"] == curso:
                media = calcular_nota_media(alumno["notas"])
                f.write(f"{alumno['nombre']} {alumno['apellidos']}: {media:.2f}\n")
    print(f"Archivo {nombre_archivo} creado correctamente.")

def menu():
    ruta = r"C:/Users/carlo/OneDrive/Escritorio/python/Vol2/notas.csv"
    alumnos = leer_alumnos(ruta)
    while True:
        print("\nMenú:")
        print("1. Mostrar listado de alumnos con nota media")
        print("2. Mostrar notas de una asignatura en un curso")
        print("3. Mostrar porcentaje de aprobados por asignatura en un curso")
        print("4. Guardar notas de un curso en un archivo")
        print("5. Salir")
        opcion = input("Elige una opción: ")
        if opcion == "1":
            mostrar_notas_medias(alumnos)
        elif opcion == "2":
            curso = input("Introduce el curso: ")
            asignatura = input("Introduce la asignatura: ")
            mostrar_notas_asignatura(alumnos, curso, asignatura)
        elif opcion == "3":
            curso = input("Introduce el curso: ")
            calcular_porcentaje_aprobados(alumnos, curso)
        elif opcion == "4":
            curso = input("Introduce el curso: ")
            guardar_notas_curso(alumnos, curso)
        elif opcion == "5":
            break
        else:
            print("Opción no válida. Inténtalo de nuevo.")

if __name__ == "__main__":
    menu()