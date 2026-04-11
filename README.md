# Proyecto_3

### Carlos Bisogno 2210041

### Alejandro Villamizar 2210439

Para ejecutar el programa se debe usar el comando "make" para la compilación de los archivos, una vez hecho eso se usa ./runMain.sh para que el archivo de prueba corra. Los resultados, de acuerdo a lo especificado, se imprimirán en la consola. Para eliminar los archivos compilados ejecutar "make clean".

Para este proyecto se utiliza un grafo implementado con listas de adyacencia, despues de haber obtenido los maximos horizontales y verticales se procede a crear y llenar el grafo conectando las adyacencias, luego se llama a la funcion nivelar agua para evitar que el agua vaya mas alto que el nivel de los edificios circundantes, y luego este va propagando esa altura, finalmente para contabilizar los tobos solo se obtiene el nivel de agua y se le resta la altura original del edicio, sumandose asi a lo ya acumulado para obtener el total de tobos que son necesarios para llenar la ciudad de atlantis.

## capH

Recorre la matriz ciudad por filas, de derecha a izquierda y viceversa, para hallar la altura máxima hasta la cual se pueden agregar cubos de agua sin que esta se desborde respecto alos edificios horizontales. Cada valor es almacenado en una matriz que posteriormente se retorna.

## capV

Recorre la matriz ciudad por columnas, de arriba a abajo y viceversa, para hallar la altura máxima hasta la cual se pueden agregar cubos de agua sin que esta se desborde respecto a los edificios verticalmente. Cada valor es almacenado en una matriz que posteriormente se retorna.

## nivelarAgua

Ajusta el nivel del agua en cada celda para asegurar que no sea más alto de lo que sus edificios vecinos pueden contener. Si encuentra que el agua se desbordaría, reduce el nivel y propaga este cambio a los edificios de al lado, garantizando que el agua se mantenga estable en toda la ciudad, todo esto lo hace recorriendo una cola de prioridad y si el edificio es mas alto que el agua que este soporta se guarda su altura para evitar conflictos

## entrada

Esta funcion construye ciudad a partir del documente atlantis.txt, toma cada linea de texto y la formatea para poder crear la matriz de la ciudad con los datos en formato Int.

## cubosDeAgua

Es la función principal del programa; coordina los cálculos de capV y capH y organiza la ciudad en forma de grafo. Se encarga de llamar a la nivelación del agua y, finalmente, calcula cuántos cubos se necesitan restando la altura de cada edificio a su nivel de agua final.

### adyacencia(conexion de vertices)

Dos vertices son adyacentes si sus edificios originales estan pegados en la ciduad y ambos tienen al menos un cubo de agua y esta se ve plasmada cuando dos vertices del grafo se conectan
