# Proyecto_3

### Carlos Bisogno 2210041

### Alejandro Villamizar 2210439

Para ejecutar el programa se debe usar el comando "make" para la compilación de los archivos, una vez hecho eso se usa ./runMain.sh para que el archivo de prueba corra. Los resultados, de acuerdo a lo especificado, se imprimirán en la consola. Para eliminar los archivos compilados ejecutar "make clean".

Para este proyecto se utiliza un grafo implementado con listas de adyacencia, despues de haber obtenido los maximos horizontales y verticales se procede a crear y llenar el grafo conectando las adyacencias, luego se llama a la funcion nivelar agua para evitar que el agua vaya mas alto que el nivel de los edificios circundantes, y luego este va propagando esa altura, finalmente para contabilizar los tobos solo se obtiene el nivel de agua y se le resta la altura original del edicio, sumandose asi a lo ya acumulado para obtener el total de tobos que son necesarios para llenar la ciudad de atlantis.

## capH

Recorre la matriz ciudad por filas, de derecha a izquierda y viceversa, para hallar la altura máxima hasta la cual se pueden agregar cubos de agua sin que esta se desborde respecto alos edificios horizontales. Cada valor es almacenado en una matriz que posteriormente se retorna.

## capV

Recorre la matriz ciudad por columnas, de arriba a abajo y viceversa, para hallar la altura máxima hasta la cual se pueden agregar cubos de agua sin que esta se desborde respecto a los edificios verticalmente. Cada valor es almacenado en una matriz que posteriormente se retorna.

## adyacencia

Dos vertices son adyacentes si sus edificios originales estan pegados en la ciduad y ambos tienen al menos un cubo de agua

## nivelarAgua

m

Modifica el nivel del agua y lo va propagando a sus vertices adyacentes

## entrada

Esta funcion construye ciudad a partir del documente atlantis.txt, toma cada linea de texto y la formatea para poder crear la matriz de la ciudad con los datos en formato Int.

## cubosDeAgua

Es el corazon del programa ya que se encarga de los llamados de capV y capH, maneja el creado de la representacion de grafo de la matriz, llama a la funcion nivelar agua y calcula con cuantos tobos se va a llenar la ciudad.
