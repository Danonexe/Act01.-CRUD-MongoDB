package repository

import ConexionMongo
import com.mongodb.client.model.Filters
import model.Juego
import org.bson.Document
import org.bson.conversions.Bson

class createJuegos {
    // Objeto para usar la conexión
    private val conexion = ConexionMongo() // Inicializa la conexión
    private val database = conexion.getDatabase("adaprueba")

    fun CreateJuego(juego: Juego) {
        try {
            // Obtener la colección
            val collection = database.getCollection("JuegosMongo")

            // Comprobar que el título no está vacío
            if (juego.titulo.isEmpty()) {
                println("El título está vacío")
                return
            }

            // Ver si ya hay otro juego con el mismo título
            val filtroBuscarPorTitulo: Bson = Filters.eq("titulo", juego.titulo)
            val existe = collection.find(filtroBuscarPorTitulo).iterator().hasNext()

            if (existe) {
                println("Ya existe un juego con este título")
                return
            }

            // Insertar objeto
            val nuevoDocumento = Document()
                .append("titulo", juego.titulo)
                .append("genero", juego.genero)
                .append("precio", juego.precio)
                .append("fechaDeLanzamiento", juego.fechaDeLanzamiento)

            collection.insertOne(nuevoDocumento)
            println("Juego insertado correctamente")

        } catch (e: Exception) {
            println("Error al conectar a MongoDB: ${e.message}")
        }
    }
}