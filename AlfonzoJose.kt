import java.io.File
import java.io.BufferedReader
import java.util.Queue

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
    val n = ciudad.size
    val m = ciudad[0].size

    val save1 = Array(n) { Array(m) {0} }
    val save2 = Array(n) { Array(m) {0} }

    for(i in 0 until n){
        var max = 0
        for (j in 0 until m){
            if(max < ciudad[i][j]) max = ciudad[i][j]
            save1[i][j] = max
        }
        max = 0
        for (j in m-1 downTo 0){
            if(max < ciudad[i][j]) max = ciudad[i][j]
            if(max < save1[i][j] ) save1[i][j] = max
        }
    }

    for(j in 0 until m){
        var max = 0
        for(i in 0 until n){
            if(max < ciudad[i][j]) max = ciudad[i][j]
            save2[i][j] = max
        }
        max = 0
        for (i in n-1 downTo 0){
            if(max < ciudad[i][j]) max = ciudad[i][j]
            if(max < save2[i][j] ) save2[i][j] = max
        }
    }

    val grafo: Grafo<String> = ListaAdyacenciaGrafo()

    var atras = Pair("",0)
    for(i in 0 until n){
        for(j in 0 until m){
            grafo.agregarVertice("${i}${j}", save1[i][j])

            if(atras.second == save1[i][j]) grafo.conectar("${i}${j}", atras.first)
            atras = Pair("${i}${j}", save1[i][j])
        }
        println()
    }


    for(i in 0 until n){
        for(j in 0 until m-1){
            if(save2[i][j] < grafo.lvlAgua("${i}${j}")) {
                grafo.setLvl("${i}${j}", save2[i][j])
                grafo.obtenerArcosSalida("${i}${j}").forEach{

                }
            }
        }
    }

    var tobos = 0
    for (i in 0 until n){
        for(j in 0 until m){
            tobos = (grafo.lvlAgua("${i}${j}") - ciudad[i][j]) + tobos
        }
    }

    return tobos
}

fun nivelarAgua(){
    var cola = ArrayDeque<String>()
    var visitados = 
}


// Tomar datos del archivo de entrada atlantis.txt y almacenarlos
fun entrada(): List<List<Int>>{
    val archivo = "atlantis.txt"
    var ciudad: MutableList<List<Int>> = mutableListOf()

    // Tomar las líneas en el archivo
    File(archivo).bufferedReader().useLines { lines ->

        // Acceder a cada línea para guardar el tamaño de los edificios
        lines.forEach { line ->
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