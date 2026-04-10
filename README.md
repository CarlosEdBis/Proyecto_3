# Proyecto_3

### Carlos Bisogno 2210041
### Alejandro Villamizar 2210439

Para ejecutar el programa se debe usar el comando make para la compilación de los archivos, una vez hecho eso se usa ./runMain.sh para que el archivo de prueba corra. Los resultados, de acuerdo a lo especificado, se imprimirán en la consola.

las funciones capH y capV guardan en una matriz auxiliar el minimo, de la capacidad maxima horizontal y verticalmente respectivamente

Para este proyecto se utiliza un grafo implementado con listas de adyacencia, despues de haber obtenido los maximos horizontales y verticales se procede a creear y llenar el grafo conectando las adyacencias dos vertices son adyacentes si la altura maxima horizontal del edificio anterior es mayor que la altura del edificio que se esta iterando, luego se llama a la funcion nivelar agua para evitar que el agua vaya mas alto que el nivel de los edificios circundantes, y luego este va propagando esa altura, finalmente para contabilizar los tobos solo se obtiene el nivel de agua y se le resta la altura original del edicio, sumandose asi a lo ya acumulado para obtener el total de tobos que son necesarios para llenar la ciudad de atlantis 