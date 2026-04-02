import java.io.File
import java.io.BufferedReader

fun cubosDeAgua(ciudad: List<List<Int>>): Int{

    /*grafo de precedencia??? no se donde
      como interpreto las posiciones???
      necesito apoyarme en la matriz para conocer la posición de los edificios
      
      Guardar cada edificio como un vertice y su capacidad de agua, quizás sirva
      además puedo conectarlo con los adyacentes que puedan tener agua
      si ninguno alrededor puede contener agua no se conecta

      Hay que tomar en cuenta la actualización de los valores por si se puede
      guardar más agua en una sección gracias a edificios adyacentes

      Una opción es crear un grafo basado en las capas, por ejemplo:
      capa 0 el suelo
      capa 1 edificios de tamaño 1
      capa 2 ....
      .
      .
      hasta el eficio más alto

      Puede funcionar pero va a continuar dependiendo de la matriz para conocer
      si puede contener agua (no está en el borde) y cuanto es lo máximo que 
      puede contener basado en los edificios adyacentes

      Sistema de alcantarillado puede buscarse con el grafo en dado caso
    */

    return 0
}

// Tomar datos del archivo de entrada atlantis.txt y almacenarlos
fun entrada(): List<List<Int>>{
    val archivo = "atlantis.txt"
    var ciudad: MutableList<List<Int>> = mutableListOf()

    // Tomar las líneas en el archivo
    File(archivo).bufferedReader().useLines { lines ->

        // Acceder a cada línea para guardar el tamaño de los edificios
        lines.drop(1).forEach { line ->
            val edf = line.split(" ")
            ciudad.add(edf.map {it.toInt()})
        }
    }

    return ciudad.toList()
}

fun main(){
    val ciudad = entrada()
    println(cubosDeAgua(ciudad))
}