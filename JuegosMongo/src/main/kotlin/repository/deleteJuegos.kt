package repository

import ConexionMongo
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import model.Juego
import org.bson.conversions.Bson

class deleteJuegos {
    // Objeto para usar la conexión
    private val conexion = ConexionMongo() // Inicializa la conexión
    private val database = conexion.getDatabase("adaprueba")

    fun borrarPorGenero(genero:String) {
        try {
            // Obtener la colección
            val collection = database.getCollection("JuegosMongo")

            // Filtro
            val filtroBuscarPorGenero: Bson = Filters.eq("genero", genero)
           collection.deleteMany(filtroBuscarPorGenero).also {
               println(it)
           }

        } catch (e: Exception) {
            println("Error al conectar a MongoDB: ${e.message}")
        }
    }
}