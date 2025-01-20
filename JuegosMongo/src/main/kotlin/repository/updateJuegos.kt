package repository

import ConexionMongo
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import model.Juego
import org.bson.Document
import org.bson.conversions.Bson

class updateJuegos {
    // Objeto para usar la conexión
    private val conexion = ConexionMongo() // Inicializa la conexión
    private val database = conexion.getDatabase("adaprueba")

    fun updateJuego(juego: Juego, tituloAntiguo:String) {
        try {
            // Obtener la colección
            val collection = database.getCollection("JuegosMongo")

            // Comprobar que el título no está vacío
            if (juego.titulo.isEmpty()) {
                println("El título está vacío")
                return
            }

            // Ver si ya hay otro juego con el mismo título
            val filtroBuscarPorTitulo: Bson = Filters.eq("titulo", tituloAntiguo)
            val existe = collection.find(filtroBuscarPorTitulo).iterator().hasNext()

            if (existe) {
                collection.updateOne(filtroBuscarPorTitulo,Updates.combine(
                    Updates.set("titulo", juego.titulo),
                    Updates.set("genero", juego.genero),
                    Updates.set("precio", juego.precio),
                    Updates.set("fechaDeLanzamiento",juego.fechaDeLanzamiento)))
            }else{
                println("No existe ningún juego con ese título")
            }


        } catch (e: Exception) {
            println("Error al conectar a MongoDB: ${e.message}")
        }
    }
}