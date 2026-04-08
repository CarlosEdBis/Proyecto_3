interface Grafo<T> {
    fun obtenerVertices(): List<T>
    fun agregarVertice(v: T, n: Int): Boolean
    fun eliminarVertice(v: T): Boolean
    fun conectar(desde: T, hasta: T): Boolean
    fun contiene(v: T): Boolean
    fun lvlAgua(v: T): Int
    fun setLvl(v: T, n: Int)
    fun obtenerArcosSalida(v: T): List<T>
    fun obtenerArcosEntrada(v: T): List<T>
    fun tamano(): Int
    fun subgrafo(vertices: Collection<T>): Grafo<T>
}