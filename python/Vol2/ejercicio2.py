import csv
cotizaciones = {}
with open(r"C:/Users/carlo/OneDrive/Escritorio/python/Vol2/cotizacion.csv", newline='', encoding='utf-8') as f:
    reader = csv.DictReader(f, delimiter=';')
    for row in reader:
        for key, value in row.items():
            if key not in cotizaciones:
                cotizaciones[key] = []
            try:
                cotizaciones[key].append(float(value))
            except ValueError:
                cotizaciones[key].append(value)

import statistics
resumen = {}
for key, values in cotizaciones.items():
    try:
        valores_numericos = [v for v in values if isinstance(v, float)]
        resumen[key] = {"min": min(valores_numericos), "max": max(valores_numericos), "media": statistics.mean(valores_numericos)}
    except ValueError:
        resumen[key] = {"min": "N/A", "max": "N/A", "media": "N/A"}

with open("resumen_cotizaciones.csv", "w", newline='', encoding='utf-8') as f:
    writer = csv.writer(f, delimiter=';')
    writer.writerow(["Columna", "Mínimo", "Máximo", "Media"])
    for key, stats in resumen.items():
        writer.writerow([key, stats["min"], stats["max"], stats["media"]])