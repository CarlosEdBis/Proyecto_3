class ListaAdyacenciaGrafo<T>(): Grafo<T>{

    val verticesLados = mutableMapOf<T, Pair<Int,MutableSet<T>>>()

    override fun tamano():Int = this.verticesLados.size

    override fun contiene(v:T):Boolean = v in this.verticesLados

    override fun obtenerVertices(): List<T> {
        return verticesLados.keys.toList()
    }

    override fun agregarVertice(v:T, n: Int): Boolean {
        if(contiene(v)) return false
        verticesLados.put(v, Pair(n, mutableSetOf<T>()))
        return true
    }

    override fun conectar(desde:T,hasta:T): Boolean {
        if (contiene(desde) && contiene(hasta)){
            verticesLados[desde]!!.second.add(hasta)
            verticesLados[hasta]!!.second.add(desde)
            return true
        }
        return false
    }

    override fun lvlAgua(v: T): Int{
        return verticesLados[v]!!.first
    }

    override fun setLvl(v: T, n: Int){
        verticesLados[v] = Pair(n, verticesLados[v]!!.second)
    }

    override fun obtenerArcosSalida(v:T): List<T>{
        if(contiene(v)){
            return verticesLados[v]!!.second.toList()
        }
        return listOf<T>()
    }

    override fun eliminarVertice(v:T): Boolean {
        if(contiene(v)){
            verticesLados.remove(v)
            for (lista in verticesLados.values){
                if (v in lista.second) {
                    lista.second.remove(v)
                }
            }
            return true
        }
        return false
    }

    override fun obtenerArcosEntrada(v:T): List<T>{
        if(contiene(v)){
            var arcosEntrada: MutableSet<T> = mutableSetOf<T>()
            for ((vertice, arcos) in verticesLados){
                if (v in arcos.second){
                    arcosEntrada.add(vertice)
                }
            }
            return arcosEntrada.toList()
        }
        return listOf<T>()
    }
    
    override fun subgrafo(vertices: Collection<T>): ListaAdyacenciaGrafo<T>{
        for(v in vertices){
            if(!(contiene(v))) return ListaAdyacenciaGrafo<T>()
        }
        val subgrafo = ListaAdyacenciaGrafo<T>()
        for (v in vertices){
            val par = this.verticesLados[v]!!
            val originales = par.second
            val copiaFiltrada: MutableSet<T> = originales.filter { it in vertices }.toMutableSet()
            subgrafo.verticesLados.put(v, Pair(par.first, copiaFiltrada))
        }
        return subgrafo
    }
}