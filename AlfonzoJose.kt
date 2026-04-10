import java.io.File
import java.io.BufferedReader
import kotlin.math.max

fun cubosDeAgua(ciudad: List<List<Int>>): Int{
    val n = ciudad.size
    val m = ciudad[0].size

    val save1 = capH(n, m, ciudad)
    val save2 = capV(n, m, ciudad)

    val grafo: Grafo<String> = ListaAdyacenciaGrafo()

    for(i in 0 until n){
        grafo.agregarVertice("${i}0", save1[i][0])

        // Almacena el "nombre" del vértice y si contiene agua o no
        var anterior = Pair("${i}0", false)

        for(j in 1 until m){
            grafo.agregarVertice("${i}${j}", save1[i][j])

            if(anterior.second && save1[i][j] > ciudad[i][j]){
                grafo.conectar("${i}${j}", anterior.first)
            }
            anterior = Pair("${i}${j}", save1[i][j] > ciudad[i][j])
        }
    }

    for(i in 0 until n){
        for(j in 0 until m){
            if(save2[i][j] < grafo.lvlAgua("${i}${j}")) {
                nivelarAgua(grafo, "${i}${j}", save2[i][j], ciudad)
            }
        }
    }

    var cubos = 0
    for (i in 0 until n){
        for(j in 0 until m){
            cubos = (grafo.lvlAgua("${i}${j}") - ciudad[i][j]) + cubos
        }
    }

    return cubos
}

// Retorna la capacidad máxima de agua que se puede contener respecto a los edificios horizontalmente
fun capH(n: Int, m: Int, ciudad: List<List<Int>>): Array<Array<Int>>{
    var s = Array(n) { Array(m) {0} }

    for(i in 0 until n){
        var max = 0
        for (j in 0 until m){
            if(max < ciudad[i][j]) max = ciudad[i][j]
            s[i][j] = max
        }
        max = 0
        for (j in m-1 downTo 0){
            if(max < ciudad[i][j]) max = ciudad[i][j]
            if(max < s[i][j]) s[i][j] = max
        }
    }
    return s
}

// Retorna la capacidad máxima de agua que se puede contener respecto a los edificios verticalmente
fun capV(n: Int, m: Int, ciudad: List<List<Int>>): Array<Array<Int>>{
    var s = Array(n) { Array(m) {0} }

    for(j in 0 until m){
        var max = 0
        for(i in 0 until n){
            if(max < ciudad[i][j]) max = ciudad[i][j]
            s[i][j] = max
        }
        max = 0
        for (i in n-1 downTo 0){
            if(max < ciudad[i][j]) max = ciudad[i][j]
            if(max < s[i][j] ) s[i][j] = max
        }
    }
    return s
}

fun nivelarAgua(G: Grafo<String>, v: String, s: Int, ciudad: List<List<Int>>){
    var cola = ArrayDeque<String>()
    var visitados = mutableMapOf<String,Boolean>()

    cola.addLast(v)
    while(cola.isNotEmpty()){
        var t = cola.removeFirst()
        visitados.put(t,true)
        val i = t[0] - '0'
        val j = t[1] - '0'

        // Evita colocar el nivel de agua por debajo de la altura del edificio
        G.setLvl(t, max(s, ciudad[i][j]))

        for(e in G.obtenerArcosSalida(t)) {
            if(e in visitados) continue
            cola.addLast(e)
        }
    }
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