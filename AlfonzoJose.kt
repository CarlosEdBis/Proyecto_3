import java.io.File
import java.io.BufferedReader

fun cubosDeAgua(ciudad: List<List<Int>>): Int{

    var tobos: Int = 0

    var maximos: MutableList<MutableList<MutableList<Int>>> = MutableList(ciudad.size) { MutableList(ciudad[it].size) { MutableList(4){0} } }
    for(i in 0..<ciudad.size){
        val fila: List<Int> = ciudad[i]
        maximos[i][0][0] = ciudad[i][0]
        for( x in 1..<fila.size){
            maximos[i][x][0] = maxOf(ciudad[i][x],maximos[i][x-1][0])
        }
    }
    for(i in 0..<ciudad.size){
        val fila: List<Int> = ciudad[i]
        maximos[i][fila.size-1][1] = ciudad[i][fila.size-1]
        for( x in fila.size-2 downTo 0){
            maximos[i][x][1] = maxOf(ciudad[i][x],maximos[i][x+1][1])
        }
    }
    for(j in 0..<ciudad[0].size){
        val columna: List<Int> = ciudad.map {it[j]}
        maximos[0][j][2] = ciudad[0][j]
        for(x in 1..<ciudad.size){
            maximos[x][j][2] = maxOf(ciudad[x][j],maximos[x-1][j][2])
        }
    }
    for(j in 0..<ciudad[0].size){
        val columna: List<Int> = ciudad.map {it[j]}
        maximos[ciudad.size-1][j][3] = ciudad[ciudad.size-1][j]
        for(x in ciudad.size-2 downTo 0){
            maximos[x][j][3] = maxOf(ciudad[x][j],maximos[x+1][j][3])
        }
    }
    for(i in 1..<ciudad.size-1){
        for(j in 1..<ciudad[0].size-1){
            tobos += maximos[i][j].min() - ciudad[i][j]
        }
    }
    
    println(maximos)

    return tobos
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