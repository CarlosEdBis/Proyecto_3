# Proyecto_3

### Carlos Bisogno 2210041
### Alejandro Villamizar 2210439

Para ejecutar el programa se debe usar el comando make para la compilación de los archivos, una vez hecho eso se usa ./runMain.sh para que el archivo de prueba corra. Los resultados, de acuerdo a lo especificado, se imprimirán en la consola.

Para este proyecto se utiliza un grafo implementado con listas de adyacencia, despues de haber obtenido los maximos horizontales y verticales se procede a creear y llenar el grafo conectando las adyacencias, luego se llama a la funcion nivelar agua para evitar que el agua vaya mas alto que el nivel de los edificios circundantes, y luego este va propagando esa altura, finalmente para contabilizar los tobos solo se obtiene el nivel de agua y se le resta la altura original del edicio, sumandose asi a lo ya acumulado para obtener el total de tobos que son necesarios para llenar la ciudad de atlantis 

# capH y CapV
las funciones capH y capV guardan en una matriz auxiliar el minimo, de la capacidad maxima horizontal y verticalmente respectivamente

# adyacencia

dos vertices son adyacentes si sus edificios originales estan pegados en la ciduad y ambos tienen al menos un cubo de agua

# nivelar agua

modifica el nivel del agua y lo va propagando a sus vertices adyacentes 

# entrada

esta funcion construye ciudad a partir del documente atlantis.txt, toma cada linea de texto y la formatea para poder crear la matriz de la ciudad con los datos en formato Int

# cubos de agua

es el corazon del programa ya que se encarga de los llamados de capV y capH, maneja el creado de la representacion de grafo de la matriz, llama a la funcion nivelar agua y calcula con cuantos tobos se va a llenar la ciudad